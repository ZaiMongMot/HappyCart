package com.starter.android.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.starter.android.R;
import com.starter.android.di.ActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashutosh Verma.
 */

public class MainActivity extends AppCompatActivity {

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
        adapter= new CategoryAdapter(viewModel.getCategories());
        recyclerView.setAdapter(adapter);
    }



}
