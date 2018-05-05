package com.jspham.happykart.android.ui.main;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import com.jspham.happykart.android.data.repos.CatalogRepository;
import com.jspham.happykart.android.model.Category;

import javax.inject.Inject;


public class CategoryListViewModel extends ViewModel{

    public CatalogRepository repository;
    private ObservableList<Category> categories;

    @Inject
    public CategoryListViewModel(CatalogRepository repository){
        this.repository=repository;
        this.categories=new ObservableArrayList<>();
    }

    public void loadCategories() {
        categories.addAll(repository.getCategories());
    }

    public ObservableList<Category> getCategories() {
        return categories;
    }

}
