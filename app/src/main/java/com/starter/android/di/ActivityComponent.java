package com.starter.android.di;

import android.app.Activity;

import com.starter.android.App;
import com.starter.android.ui.main.MainActivity;
import com.starter.android.ui.productdetail.ProductDetailActivity;
import com.starter.android.ui.productlist.ProductListActivity;

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
