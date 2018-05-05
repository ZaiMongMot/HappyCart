package com.happykart.android.ui.main;


import android.arch.lifecycle.ViewModel;

import com.happykart.android.model.Category;

public class CategoryItemViewModel extends ViewModel{


    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
