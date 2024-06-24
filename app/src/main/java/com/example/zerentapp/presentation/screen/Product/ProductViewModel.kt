package com.example.zerentapp.presentation.screen.Product

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zerentapp.presentation.screen.Order.Order
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Product(
    val id: String = "",
    val productName: String = "",
    val productHarga: String = "",
    val productImage: String = "",
    val productLokasi: String = "",
    val productCategory: String = "",
    val productDescription: String = "",
)

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {
    private val _barangs = MutableStateFlow<List<Product>>(emptyList())
    val barangs: StateFlow<List<Product>> = _barangs

//    init {
//        fetchProducts()
//    }

    private fun fetchRentals() {
        viewModelScope.launch {
            firestore.collection("products").get()
                .addOnSuccessListener { result ->
                    val productList = result.documents.mapNotNull { document ->
                        document.toObject(Product::class.java)?.copy(id = document.id)
                    }
                    _barangs.value = productList
                }
                .addOnFailureListener { exception ->
                }
        }
    }
}