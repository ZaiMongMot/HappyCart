package com.starter.android.ui.base;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Ashutosh Verma.
 */

public abstract class ItemViewModel<ITEM_T> extends ViewModel {

    public ItemViewModel() {
        super();
    }
    public abstract void setItem(ITEM_T item);
}
