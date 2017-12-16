package com.starter.android.data.local;

import android.util.Log;

import io.realm.Realm;

/**
 * Created by ishan.dhingra on 30/08/17.
 */

public class RealmLocalStore implements LocalDataStore {

    private final Realm realm;

    public RealmLocalStore(Realm realm) {
        this.realm = realm;
        Log.e("Event", "Realm Initialized");
    }

}
