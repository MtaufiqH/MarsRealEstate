package app.taufiq.marsrealestate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.taufiq.marsrealestate.remote.MarsApi
import app.taufiq.marsrealestate.remote.MarsProperty
import kotlinx.coroutines.launch

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


     private val _properties = MutableLiveData<List<MarsProperty>>()
     val properties: LiveData<List<MarsProperty>>
         get() = _properties

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
        viewModelScope.launch {
            try {
                _properties.value = MarsApi.retrofitService.getProperties()
                _response.value = "Success: Mars properties retrieved"

            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }

        }
    }
}