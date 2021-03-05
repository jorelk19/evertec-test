package com.evertec.edson.ui.viewModels.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations

fun <T> LiveData<T>.distinctUntilChanged(): LiveData<T> {
    val mutableLiveData: MediatorLiveData<T> = MediatorLiveData()
    var latestValue: T? = null
    mutableLiveData.addSource(this) {
        if (latestValue != it) {
            mutableLiveData.value = it
            latestValue = it
        }
    }
    return mutableLiveData
}

fun <T, O> LiveData<T>.map(function: (T) -> O): LiveData<O> {
    return Transformations.map(this, function)
}