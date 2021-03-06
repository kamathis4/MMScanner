package com.adi.mmscanner.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adi.mmscanner.repository.BarcodeRepository
import com.adi.mmscanner.Barcodedata
import kotlinx.coroutines.launch

class BarcodeSendViewModel(
    private val repository: BarcodeRepository
): ViewModel() {

    //Create live data, mutable livedata in list for posting during retrieve


    private val _BarcodeLiveData = MutableLiveData<Barcodedata>()
    val BarcodeLiveData: LiveData<Barcodedata> = _BarcodeLiveData


    fun sendData(data: Barcodedata) = repository.repoSaveData(data)

    fun validateData(data: Barcodedata){
        _BarcodeLiveData.postValue(data)
    }
}