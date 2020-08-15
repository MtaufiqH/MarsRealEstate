package app.taufiq.marsrealestate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.taufiq.marsrealestate.remote.MarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created By Taufiq on 8/15/2020.
 *
 */
class OverviewViewModel : ViewModel() {
    // The internal MutableLiveData String that stores the most recent response
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties()
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties() {
        MarsApi.retrofitService.getProperties().enqueue(object: Callback<String>{
            /**
             * the [onFailure] callback is called when the web service response fail
             * */
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "failure ${t.message}"

            }

            /**
             * [onResponse] Callback is called when the request is successful
             * and web service return a response.
             * */
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

        })
    }
}