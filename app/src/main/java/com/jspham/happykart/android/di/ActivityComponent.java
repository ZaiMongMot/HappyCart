package com.jspham.happykart.android.di;

import android.app.Activity;

import com.jspham.happykart.android.App;
import com.jspham.happykart.android.ui.main.MainActivity;
import com.jspham.happykart.android.ui.productdetail.ProductDetailActivity;
import com.jspham.happykart.android.ui.productlist.ProductListActivity;

import dagger.Subcomponent;

/**
 * Created by Ashutosh Verma.
 */

@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);
    void inject(ProductListActivity activity);
    void inject(ProductDetailActivity activity);


    public static ActivityComponent component(Activity activity){
        return App.component(activity).plusActivityModule(new ActivityModule(activity));
    }
}
