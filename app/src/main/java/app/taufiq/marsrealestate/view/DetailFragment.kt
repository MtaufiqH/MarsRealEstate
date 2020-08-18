package app.taufiq.marsrealestate.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import app.taufiq.marsrealestate.databinding.FragmentDetailBinding
import app.taufiq.marsrealestate.viewmodel.DetailViewModel
import app.taufiq.marsrealestate.viewmodel.DetailViewmodelFactory


/**
 * This [Fragment] shows the detailed information about a selected piece of Mars real estate.
 * It sets this information in the [DetailViewModel], which it gets as a Parcelable property
 * through Jetpack Navigation's SafeArgs.
 */
class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val marsProperty = DetailFragmentArgs.fromBundle(arguments!!).selectedProperty
        val viewModelFactory = DetailViewmodelFactory(marsProperty, application)

        binding.viewmodel =
            ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        return binding.root
    }

}