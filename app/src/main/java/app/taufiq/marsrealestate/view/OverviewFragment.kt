package app.taufiq.marsrealestate.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import app.taufiq.marsrealestate.R
import app.taufiq.marsrealestate.adapter.PhotoGridAdapter
import app.taufiq.marsrealestate.databinding.FragmentOverviewBinding
import app.taufiq.marsrealestate.databinding.GridViewItemBinding
import app.taufiq.marsrealestate.remote.MarsApiFilter
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
//         val binding = GridViewItemBinding.inflate(inflater)

        // allows data binding to observe LiveData with the lifecycle of this fragment
        binding.lifecycleOwner = this

        // give the binding access to OverviewViewModel
        binding.viewmodel = viewmodel

        binding.marsRvId.adapter = PhotoGridAdapter(PhotoGridAdapter.OnClickListener{
            viewmodel.displayPropertyDetails(it)
        })

        // navigate to the Detail Fragment
        viewmodel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer {
            this.findNavController().navigate(OverviewFragmentDirections.toDetailAction(it))
            viewmodel.displayPropertyDetailsComplete()
        })

        setHasOptionsMenu(true)

        return binding.root

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewmodel.updateFilter(
            when(item.itemId){
                R.id.show_rent_menu -> MarsApiFilter.SHOW_RENT
                R.id.show_buy_menu -> MarsApiFilter.SHOW_BUY

                else -> MarsApiFilter.SHOW_ALL
            }
        )

        return true
    }

}