package com.starter.android.di;

import com.starter.android.util.ActivityRouter;
import com.starter.android.util.ImageUtil;
import com.starter.android.util.Utils;

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
    ActivityRouter providesActivityRouter(){
        return new ActivityRouter();
    }

    @Provides
    @Singleton
    ImageUtil providesImageUtil(){
        return new ImageUtil();
    }


}
