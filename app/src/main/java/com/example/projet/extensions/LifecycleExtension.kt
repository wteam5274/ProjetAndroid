package com.example.projet.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Developed by skydoves on 2018-08-19.
 * Copyright (c) 2018 skydoves rights reserved.
 */

inline fun <T> LifecycleOwner.observeLiveData(data: LiveData<T>, crossinline onChanged: (T) -> Unit) {
  data.observe(this, Observer {
    it?.let { value -> onChanged(value) }
  })
}
