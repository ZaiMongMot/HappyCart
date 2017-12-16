package com.starter.android;


import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.backends.okhttp3.OkHttpImagePipelineConfigFactory;
import com.starter.android.di.AppComponent;
import com.starter.android.di.ContextComponent;
import com.starter.android.di.ContextModule;
import com.starter.android.util.Foreground;

import java.io.IOException;

import io.realm.Realm;
import okhttp3.OkHttpClient;

public class StarterApp extends MultiDexApplication{

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this, OkHttpImagePipelineConfigFactory.newBuilder(this, new OkHttpClient()).setDownsampleEnabled(true).build());
        Realm.init(this);

        appComponent=AppComponent.component(this);
        initForeground();
    }



    public static AppComponent getAppComponent(Context context) {
       return ((StarterApp)context.getApplicationContext()).appComponent;
    }

    public static ContextComponent getContextComponent(Context context) {
        return ((StarterApp)context.getApplicationContext()).appComponent.plusContextModule(new ContextModule(context));
    }


    public void initForeground(){
        Foreground.init(this).addListener(new Foreground.Listener() {
            @Override
            public void onBecameForeground() {
                Log.e("Event", "onBecameForeground");
            }

            @Override
            public void onBecameBackground() throws IOException {
                Log.e("Event", "onBecameBackground");
            }
        });
    }

}
