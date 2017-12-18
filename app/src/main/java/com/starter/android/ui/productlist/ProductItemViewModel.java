package com.starter.android.ui.productlist;


import android.arch.lifecycle.ViewModel;

import com.starter.android.model.Product;

public class ProductItemViewModel extends ViewModel{

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPrice() {
        return "\u20B9 " + product.getPrice();
    }
}
