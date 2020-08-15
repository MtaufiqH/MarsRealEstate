package app.taufiq.marsrealestate.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import app.taufiq.marsrealestate.remote.MarsProperty

/**
 * Created By Taufiq on 8/15/2020.
 *
 */
@Suppress("UNCHECKED_CAST")
class DetailViewmodelFactory(private val marsProperty: MarsProperty, private val app: Application) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(marsProperty, app) as T
        }
        throw IllegalArgumentException("Unknown viewModel Class")
    }


}