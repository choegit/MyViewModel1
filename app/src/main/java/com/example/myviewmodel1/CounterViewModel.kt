package com.example.myviewmodel1

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class CounterViewModel : ViewModel() {
    private val _counter = MutableLiveData(0)
    val counter : LiveData<Int> get() = _counter

    fun increment() {
        _counter.value = (_counter.value ?: 0) + 1
    }

    fun decrement() {
        _counter.value = (_counter.value ?: 0) - 1
    }

    fun reset() {
        _counter.value = 0
    }

}