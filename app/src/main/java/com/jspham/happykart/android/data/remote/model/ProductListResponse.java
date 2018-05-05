package com.happykart.android.data.remote.model;

import com.happykart.android.model.Product;

import java.util.List;



public class ProductListResponse {

    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
