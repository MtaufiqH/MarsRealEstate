package app.taufiq.marsrealestate.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.taufiq.marsrealestate.remote.MarsApi
import app.taufiq.marsrealestate.remote.MarsApiFilter
import app.taufiq.marsrealestate.remote.MarsProperty
import kotlinx.coroutines.launch

/**
 * Created By Taufiq on 8/15/2020.
 *
 */
enum class MarsApiStatus {
    LOADING, ERROR, DONE
}

class OverviewViewModel : ViewModel() {
    // The internal MutableLiveData String that stores the most recent response
    private val _status = MutableLiveData<MarsApiStatus>()

    // The external immutable LiveData for the response String
    val status: LiveData<MarsApiStatus>
        get() = _status


    private val _properties = MutableLiveData<List<MarsProperty>>()
    val properties: LiveData<List<MarsProperty>>
        get() = _properties

    /**
     * Call getMarsRealEstateProperties() on init so we can display status immediately.
     */
    init {
        getMarsRealEstateProperties(MarsApiFilter.SHOW_ALL)
    }

    /**
     * Sets the value of the status LiveData to the Mars API status.
     */
    private fun getMarsRealEstateProperties(filter: MarsApiFilter) {

        viewModelScope.launch {
            _status.value = MarsApiStatus.LOADING
            try {
                _properties.value = MarsApi.retrofitService.getProperties(filter.value)
                _status.value = MarsApiStatus.DONE

            } catch (e: Exception) {
                _status.value = MarsApiStatus.ERROR
                _properties.value = ArrayList()
            }

        }
    }


    /**an updateFilter() method
     * that takes a MarsApiFilter argument and calls
     * getMarsRealEstateProperties() with that argument.
     * */
    fun updateFilter(filter: MarsApiFilter){
        getMarsRealEstateProperties(filter)
    }
}