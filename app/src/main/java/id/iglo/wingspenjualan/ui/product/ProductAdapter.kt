package id.iglo.wingspenjualan.ui.product

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.iglo.common.base.Constants
import id.iglo.common.entity.Product
import id.iglo.wingspenjualan.databinding.ProductListItemBinding

class ProductAdapter(
    val startSupportActionModeClick: (Product) -> Unit,
    val getSelection: () -> List<Product>,
    val toggleClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductViewHolder>() {
    val differ = AsyncListDiffer(this, itemCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.data = data
        holder.binding.isSelected = getSelection().contains(data)
        holder.binding.productPriceBeforeDiscount.text =
            Constants.indonesiaCurrencyFormat.format(data.price)
        holder.binding.productPriceBeforeDiscount.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
        holder.binding.productPriceAfterDiscount.text =
            Constants.indonesiaCurrencyFormat.format(
                Constants.discountPrice(
                    data.price,
                    data.discount
                )
            )
        holder.binding.buyButton.setOnClickListener {
            startSupportActionModeClick(data)
        }
        holder.binding.root.setOnClickListener {
            toggleClick(data)
        }
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

    fun toggleSelection(product: Product, changes: () -> Unit) {
        val toggleDiffUtil = object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = differ.currentList.size

            override fun getNewListSize(): Int = differ.currentList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = true

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return differ.currentList[oldItemPosition] != product
            }
        }
        val differ = DiffUtil.calculateDiff(toggleDiffUtil)
        changes()
        differ.dispatchUpdatesTo(this)
    }

    fun clearSelection(changes: (() -> Unit)?) {

        val toggleDiffUtil = object : DiffUtil.Callback() {
            override fun getOldListSize(): Int = differ.currentList.size

            override fun getNewListSize(): Int = differ.currentList.size

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = true

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return !getSelection().contains(differ.currentList[oldItemPosition])
            }
        }
        val differ = DiffUtil.calculateDiff(toggleDiffUtil)
        changes?.invoke()
        differ.dispatchUpdatesTo(this)
    }
}

class ProductViewHolder(val binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root)