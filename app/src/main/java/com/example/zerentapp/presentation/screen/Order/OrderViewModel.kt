package com.example.zerentapp.presentation.screen.Order

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Order(
    val id: String = "",
    val productName: String = "",
    val productHarga: String = "",
    val productImage: String = "",
    val rentalStatus: String = "",
    val rentalEndDate: String = "",
    val rentalStartDate: String = "",
    val rentalDuration: Int = 0,
)



@HiltViewModel
class OrderViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {
    private val _products = MutableStateFlow<List<Order>>(emptyList())
    val products: StateFlow<List<Order>> = _products

    init {
        fetchProductsByStatus(status = "pending")
    }

    private fun fetchRentals() {
        viewModelScope.launch {
            firestore.collection("rentals").get()
                .addOnSuccessListener { result ->
                    val productList = result.documents.mapNotNull  { document ->
                        document.toObject(Order::class.java)?.copy(id = document.id)}
                    _products.value = productList
                }
                .addOnFailureListener { exception ->
                }
        }
    }

    fun fetchProductsByStatus(status: String) {
        viewModelScope.launch {
            firestore.collection("rentals")
                .whereEqualTo("rentalStatus", status)
                .get()
                .addOnSuccessListener { result ->
                    val filteredProducts = result.documents.mapNotNull { document ->
                        document.toObject(Order::class.java)?.copy(id = document.id)}
                    _products.value = filteredProducts
                    Log.d("OrderViewModel", "Fetched products by status $status: $filteredProducts")
                }
                .addOnFailureListener { exception ->
                }
        }
    }

    fun updateProductStatus(id: String, newStatus: String) {
        viewModelScope.launch {
            firestore.collection("rentals").document(id)
                .update("rentalStatus", newStatus)
                .addOnSuccessListener {
                    Log.d("OrderViewModel", "Product status updated successfully")
                    fetchProductsByStatus(status = newStatus)
                }
                .addOnFailureListener { exception ->
                    Log.e("OrderViewModel", "Error updating product status", exception)
                }
        }
    }
}