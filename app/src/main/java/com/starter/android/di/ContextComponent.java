package com.starter.android.di;

import com.starter.android.ui.splash.SplashActivity;

import dagger.Subcomponent;

/**
 * Created by ishan.dhingra on 30/08/17.
 */

@Subcomponent(modules = ContextModule.class)
public interface ContextComponent {

    void inject(SplashActivity activity);

}
