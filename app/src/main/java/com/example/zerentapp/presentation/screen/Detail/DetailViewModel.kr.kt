package com.example.zerentapp.presentation.screen.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


data class Detail(
    val productName: String = "",
    val productHarga: String = "",
    val productImage: String = "",
    val productStatus: String = "",
    val rentalEndDate: String = "",
    val rentalStartDate: String = "",
)



@HiltViewModel
class DetailViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {
    private val _products = MutableStateFlow<List<Detail>>(emptyList())
    val products: StateFlow<List<Detail>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            firestore.collection("rentals").get()
                .addOnSuccessListener { result ->
                    val productList = result.documents.mapNotNull { it.toObject(Detail::class.java) }
                    _products.value = productList
                }
                .addOnFailureListener { exception ->
                    // Handle the error
                }
        }
    }
}
