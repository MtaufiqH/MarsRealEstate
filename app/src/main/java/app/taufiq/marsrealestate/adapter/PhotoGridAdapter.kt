package app.taufiq.marsrealestate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import app.taufiq.marsrealestate.databinding.GridViewItemBinding
import app.taufiq.marsrealestate.remote.MarsProperty

/**
 * Created By Taufiq on 8/15/2020.
 *
 */

class PhotoGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<MarsProperty, PhotoGridAdapter.MarsViewHolder>(CallbackDiff) {


    class MarsViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(marsProperty: MarsProperty){
            binding.property = marsProperty
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarsViewHolder {
        return MarsViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)
    }



    companion object CallbackDiff: DiffUtil.ItemCallback<MarsProperty>(){
        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
           return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty): Boolean {
            return oldItem.id == newItem.id
        }

    }

    class OnClickListener(val clickListener: (marsProperty: MarsProperty) -> Unit){
        fun onClick(marsProperty: MarsProperty) = clickListener(marsProperty)
    }
}





