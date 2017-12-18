package com.happykart.android.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.happykart.android.R;
import com.happykart.android.data.repos.CartRepository;
import com.happykart.android.di.ActivityComponent;
import com.happykart.android.util.ActivityRouter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashutosh Verma.
 */

public class MainActivity extends AppCompatActivity {

    @Inject
    ActivityRouter router;
    @Inject
    CartRepository cartRepository;
    @Inject
    CategoryListViewModel viewModel;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    private Context context;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ActivityComponent.component(this).inject(this);

        context=this;
        viewModel.loadCategories();

        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        adapter= new CategoryAdapter(router, viewModel.getCategories());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem cartItem = menu.getItem(0);
        ((TextView)cartItem.getActionView()
                .findViewById(R.id.txtCartQuantity))
                .setText(String.valueOf(cartRepository.getCartCount()));
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        invalidateOptionsMenu();
    }

}
