package id.iglo.wingspenjualan.ui.checkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.iglo.common.entity.Product
import id.iglo.wingspenjualan.databinding.CheckoutItemBinding
import id.iglo.wingspenjualan.databinding.ProductListItemBinding
import id.iglo.wingspenjualan.ui.product.ProductViewHolder

class CheckoutAdapter : RecyclerView.Adapter<CheckoutViewHolder>() {
    val differ = AsyncListDiffer(this, itemCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        return CheckoutViewHolder(
            CheckoutItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.data = data
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    companion object {
        val itemCallback = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem.productCode == newItem.productCode
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
                return oldItem == newItem
            }
        }
    }

}

class CheckoutViewHolder(val binding: CheckoutItemBinding) : RecyclerView.ViewHolder(binding.root)