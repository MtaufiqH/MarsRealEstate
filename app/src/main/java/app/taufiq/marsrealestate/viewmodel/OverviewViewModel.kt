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


     private val _property = MutableLiveData<MarsProperty>()
     val property: LiveData<MarsProperty>
         get() = _property

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
                val listResult = MarsApi.retrofitService.getProperties()
                _response.value = "Success: $listResult mars properties retrieved"

                if (listResult.isNotEmpty()){
                    /**
                     *  If MarsProperty objects are available,
                     *  this test sets the value of the
                     *  _property LiveData to the first property in the listResult.
                     * */
                    _property.value = listResult[0]
                }

            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }

        }
    }
}