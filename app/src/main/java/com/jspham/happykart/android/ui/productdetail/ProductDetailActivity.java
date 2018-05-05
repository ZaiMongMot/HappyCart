package com.jspham.happykart.android.ui.productdetail;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.jspham.happykart.android.R;
import com.jspham.happykart.android.data.repos.CartRepository;
import com.jspham.happykart.android.data.repos.CatalogRepository;
import com.jspham.happykart.android.databinding.ActivityProductDetailBinding;
import com.jspham.happykart.android.di.ActivityComponent;
import com.jspham.happykart.android.util.ToastUtil;

import javax.inject.Inject;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String KEY_PRODUCT_ID = "productId";

    @Inject
    CatalogRepository catalogRepository;
    @Inject
    CartRepository cartRepository;
    @Inject
    ToastUtil toastUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityComponent.component(this).inject(this);

        long productId = getIntent().getLongExtra(KEY_PRODUCT_ID, 0);

        ProductDetailsViewModel viewModel = new ProductDetailsViewModel(catalogRepository, cartRepository, productId, toastUtil);
        ActivityProductDetailBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        binding.setVm(viewModel);
        viewModel.loadProduct();

        setSupportActionBar(binding.toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        binding.collapsibleToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
