package com.starter.android.di;

import android.app.Activity;

import com.starter.android.App;
import com.starter.android.ui.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Ashutosh Verma.
 */

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity activity);


    public static ActivityComponent component(Activity activity){
        return App.component(activity).plusActivityModule(new ActivityModule(activity));
    }
}
