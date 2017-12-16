package com.starter.android.di;
import com.starter.android.data.local.LocalDataStore;
import com.starter.android.data.local.RealmLocalStore;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;


@Module
public class PersistenceModule {

    private final boolean isInMemory;

    public PersistenceModule(boolean isInMemory) {
        this.isInMemory = isInMemory;
    }

    @Provides
    @Singleton
    public RealmConfiguration providesRealmConfiguration() {
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder();
        builder.deleteRealmIfMigrationNeeded();
        if (isInMemory)builder.inMemory();
        return builder.build();
    }

    @Provides
    public Realm providesRealm(RealmConfiguration realmConfiguration) {
        return Realm.getInstance(realmConfiguration);
    }

    @Provides
    public LocalDataStore providesLocalDataStore(Realm realm) {
        return new RealmLocalStore(realm);
    }

}
