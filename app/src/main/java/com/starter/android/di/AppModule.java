package com.starter.android.di;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Verma.
 */

@Singleton
@Module(includes = {NetworkModule.class, PersistenceModule.class})
public class AppModule {

    private Application app;

    public AppModule(Application app) {
        this.app=app;
    }

    @Provides
    @Singleton
    Context providesContext(){
        return app;
    }


}
