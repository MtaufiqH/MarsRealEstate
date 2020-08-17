package app.taufiq.marsrealestate.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.taufiq.marsrealestate.remote.MarsProperty

/**
 * Created By Taufiq on 8/15/2020.
 *
 */
class DetailViewModel(marsProperty: MarsProperty, app: Application) :
    AndroidViewModel(app) {

    private val _selectedProperty = MutableLiveData<MarsProperty>()

    val selectedProperty: LiveData<MarsProperty>
    get() = _selectedProperty


    init {
        _selectedProperty.value = marsProperty
    }




}