package app.taufiq.marsrealestate.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import app.taufiq.marsrealestate.R
import app.taufiq.marsrealestate.databinding.FragmentOverviewBinding
import app.taufiq.marsrealestate.viewmodel.OverviewViewModel


/**
 * This fragment shows the the status of the Mars real-estate web services transaction.
 */
class OverviewFragment : Fragment() {

    /**
     * Lazily  initialize our [OverviewViewModel].
     * */
    private val viewmodel: OverviewViewModel by lazy {
        @Suppress("DEPRECATION")
        ViewModelProviders.of(this).get(OverviewViewModel::class.java)
    }


    /**
     * Inflates the layout with Data Binding, sets its lifecycle owner to the OverviewFragment
     * to enable Data Binding to observe LiveData, and sets up the RecyclerView with an adapter.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        // allows data binding to observe LiveData with the lifecycle of this fragment
        binding.lifecycleOwner = this

        // give the binding access to OverviewViewModel
        binding.viewmodel = viewmodel

        setHasOptionsMenu(true)

        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

}