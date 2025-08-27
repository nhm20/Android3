package com.example.android3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach

class MyViewModel : ViewModel() {
    private val _result= MutableLiveData<String>()
    val result: LiveData<String> get()=_result

    fun startWork(){
        viewModelScope.launch{
            try{
                _result.value="Starting ..."
                val data=fetchData()
                _result.value="Data fetched: $data"
            }catch (e: Exception) {
                _result.value="Error: ${e.message}"
            }
        }
    }

    private suspend fun fetchData(): String = withContext(Dispatchers.IO) {
        delay(2000)
        return@withContext "Hello from suspend function"
    }
    fun startWithTimeout(){
        viewModelScope.launch {
            try {
                val result = withTimeout(1500){
                    delay(1000)
                    "Completed before timeout"
                }
                _result.value = result
            } catch (e: TimeoutCancellationException) {
                _result.value = "Timeout!"
            }
        }
    }
    fun collectFlow(){
        viewModelScope.launch {
            createFlow().onEach {
                _result.value = it
            }.collect()
        }
    }
    private  fun createFlow(): Flow<String> = flow{
        emit("Flow started")
        delay(1000)
        emit("Flow emitted value")
    }

    override fun onCleared() {
        super.onCleared()
//        automatic coroutines cancellation for viewModelScope

    }
}