package id.iglo.common.ext

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<ArrayList<T>>.toggle(t: T) {
    val data = this.value.orEmpty()
    val ar = arrayListOf<T>().apply { this.addAll(data) }
    ar.toggle(t)
    value = ar
}


fun <T> MutableLiveData<ArrayList<T>>.size(): Int {
    val data = this.value.orEmpty()
    return data.size
}

fun <T> MutableLiveData<ArrayList<T>>.isEmpty(): Boolean {
    val data = this.value.orEmpty()
    return data.isEmpty()
}
fun <T> MutableLiveData<ArrayList<T>>.clear() {
    this.value = arrayListOf()
}