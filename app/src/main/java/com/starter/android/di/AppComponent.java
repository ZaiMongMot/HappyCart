package com.starter.android.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Ashutosh Verma.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    ContextComponent plusContextModule(ContextModule contextModule);

    public static AppComponent component(Application app){
        return DaggerAppComponent.builder().appModule(new AppModule(app)).networkModule(new NetworkModule()).persistenceModule(new PersistenceModule(false)).build();
    }

}
