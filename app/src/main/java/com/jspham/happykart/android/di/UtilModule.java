package com.jspham.happykart.android.di;

import android.content.Context;

import com.jspham.happykart.android.util.ImageUtil;
import com.jspham.happykart.android.util.ToastUtil;
import com.jspham.happykart.android.util.Utils;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ashutosh Verma.
 */

@Singleton
@Module
public class UtilModule {


    @Provides
    @Singleton
    Utils providesUtils(){
        return new Utils();
    }

    @Provides
    @Singleton
    ImageUtil providesImageUtil(){
        return new ImageUtil();
    }

    @Provides
    @Singleton
    ToastUtil providesToastUtil(@AppContext Context context){
        return new ToastUtil(context);
    }


}
