package id.iglo.wingspenjualan.ui.checkout

import android.annotation.SuppressLint
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import id.iglo.common.base.Constants
import id.iglo.common.entity.Product
import id.iglo.wingspenjualan.databinding.CheckoutItemBinding

class CheckoutAdapter(
    val sumSubTotal: (Product, Long) -> Unit
) :
    RecyclerView.Adapter<CheckoutViewHolder>() {
    val differ = AsyncListDiffer(this, itemCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        return CheckoutViewHolder(
            CheckoutItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.data = data
        holder.binding.subtotalPrice.text =
            "Sub Total : ${Constants.indonesiaCurrencyFormat.format((data.price - (data.price * data.discount / 100)))}"
        holder.binding.inputData.setText("1")
        holder.binding.inputData.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    var subTotal =
                        s.toString().toInt() * Constants.discountPrice(data.price, data.discount)
                    holder.binding.subtotalPrice.text =
                        "Sub Total : ${
                            Constants.indonesiaCurrencyFormat.format(
                                subTotal
                            )
                        }"
                    sumSubTotal(data, subTotal)
                } else {
                    var subTotalOnePcs = Constants.discountPrice(data.price, data.discount)
                    holder.binding.inputData.setText("1")
                    holder.binding.subtotalPrice.text =
                        "Sub Total : ${Constants.indonesiaCurrencyFormat.format(subTotalOnePcs)}"
                    sumSubTotal(data, subTotalOnePcs)
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
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