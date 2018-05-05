package com.jspham.happykart.android.data.repos;


import com.jspham.happykart.android.data.local.LocalRealmDB;
import com.jspham.happykart.android.model.CartEntry;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.realm.RealmResults;

@Singleton
public class CartRepository{

    private LocalRealmDB db;

    @Inject
    public CartRepository(LocalRealmDB db) {
        this.db=db;
    }

    public void addToCart(long productId) {
        db.addToCart(productId);
    }

    public RealmResults<CartEntry> getCartEntry(long productId) {
        return db.getCartEntryByProduct(productId);
    }

    public void removeFromCart(long productId) {
        db.removeFromCart(productId);
    }

    public long getCartCount() {
        return db.getCartCount();
    }

}
