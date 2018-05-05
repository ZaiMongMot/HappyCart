package com.happykart.android.ui.productlist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.happykart.android.R;
import com.happykart.android.databinding.ActivityProductListBinding;
import com.happykart.android.di.ActivityComponent;
import com.happykart.android.model.Product;
import com.happykart.android.util.ActivityRouter;

import javax.inject.Inject;

import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.RealmResults;

/**
 * Created by Ashutosh Verma.
 */

public class ProductListActivity extends AppCompatActivity {

    @Inject
    ActivityRouter router;
    @Inject
    ProductListViewModel viewModel;

    private Context context;
    private String category;
    private ProductListAdapter adapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityComponent.component(this).inject(this);

        context=this;
        ActivityProductListBinding binding=DataBindingUtil.setContentView(this, R.layout.activity_product_list);

        category=getIntent().getStringExtra("category");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(category);

        viewModel.setCategory(category);
        binding.setVm(viewModel);

        layoutManager=new LinearLayoutManager(context);
        binding.recyclerView.setLayoutManager(layoutManager);
        adapter=new ProductListAdapter(router, viewModel.getProducts());
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!viewModel.hasMore()) {
                    return;
                }
                int currentPage = (layoutManager.findLastCompletelyVisibleItemPosition()+1)/10;
                if (currentPage >= viewModel.getPage()) {
                    viewModel.loadForPage(currentPage + 1);
                }
            }
        });

        viewModel.loadForPage(1);
        viewModel.getProducts().addChangeListener(changeListener);

    }



    private final OrderedRealmCollectionChangeListener<RealmResults<Product>> changeListener =
            new OrderedRealmCollectionChangeListener<RealmResults<Product>>() {
                @Override
                public void onChange(RealmResults<Product> collection, OrderedCollectionChangeSet changeSet) {
                    // `null`  means the async query returns the first time.
                    if (changeSet == null) {
                        adapter.notifyDataSetChanged();
                        return;
                    }
                    // For deletions, the adapter has to be notified in reverse order.
                    OrderedCollectionChangeSet.Range[] deletions = changeSet.getDeletionRanges();
                    for (int i = deletions.length - 1; i >= 0; i--) {
                        OrderedCollectionChangeSet.Range range = deletions[i];
                        adapter.notifyItemRangeRemoved(range.startIndex, range.length);
                    }

                    OrderedCollectionChangeSet.Range[] insertions = changeSet.getInsertionRanges();
                    for (OrderedCollectionChangeSet.Range range : insertions) {
                        adapter.notifyItemRangeInserted(range.startIndex, range.length);
                    }

                    OrderedCollectionChangeSet.Range[] modifications = changeSet.getChangeRanges();
                    for (OrderedCollectionChangeSet.Range range : modifications) {
                        adapter.notifyItemRangeChanged(range.startIndex, range.length);
                    }
                }
            };


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    
}
