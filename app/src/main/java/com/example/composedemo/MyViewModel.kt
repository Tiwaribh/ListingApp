package com.example.composedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener

class MyViewModel :ViewModel() {
    var itemList: MutableLiveData<List<ResponseModel>>
    var error: MutableLiveData<String?>

    init {
        itemList = MutableLiveData()
        error = MutableLiveData()
    }

    /*****
     * Method to call api
     * ********/
    fun callApi(){
        AndroidNetworking.get(AppConstants.GET_URL)
            .setTag(this)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsObjectList(
                ResponseModel::class.java,
                object : ParsedRequestListener<List<ResponseModel>> {
                    override fun onResponse(item: List<ResponseModel>) {
                       itemList.value=item
                    }
                    override fun onError(anError: ANError) {
                       error.value=anError?.localizedMessage
                    }
                })
    }

}