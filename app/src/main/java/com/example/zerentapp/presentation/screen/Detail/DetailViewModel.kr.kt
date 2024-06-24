package com.example.zerentapp.presentation.screen.Detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.Date
import javax.inject.Inject


data class Detail(
    val id: String = "",
    val productDesc: String = "",
    val productDistance: String = "",
    val productImage: String = "",
    val productDurationss: String = "",
    val productHarga: String = "",
    val productKondisi: String = "",
    val productPenjual: String = "",
    val productRating: String = "",
    val productName: String = "",
)
data class Rental(
    val productName: String = "",
    val productHarga: String = "",
    val productImage: String = "",
    val productStatus: String = "",
    val rentalEndDate: String = "",
    val rentalStartDate: String = "",
    val userId: String = "",
    val rentalStatus: String = "",
    val rentedAt: Date = Date(),
    val quantity: Int = 0,
    val rentalDuration: Int = 0
)


@HiltViewModel
class DetailViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {
    private val _products = MutableStateFlow<List<Detail>>(emptyList())
    val products: StateFlow<List<Detail>> = _products

    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    fun calculateRentalDates(durationInDays: Int): Pair<String, String> {
        val startDate = LocalDate.now()
        val endDate = startDate.plusDays(durationInDays.toLong())

        return Pair(startDate.format(dateFormatter), endDate.format(dateFormatter))
    }

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            firestore.collection("products").get()
                .addOnSuccessListener { result ->
                    val productList = result.documents.mapNotNull { document ->
                        document.toObject(Detail::class.java)?.copy(id = document.id)
                    }
                    _products.value = productList
                }
                .addOnFailureListener { exception ->
                }
        }
    }

   fun fetchProductsDetail(id: String) {
        val documentId = "C2RWfuFWiXYPv5Hzuuev"
        viewModelScope.launch {
            firestore.collection("products").document(id).get()
                .addOnSuccessListener { document ->
                    if (document.exists()) {
                        val product = document.toObject(Detail::class.java)
                        product?.let {
                            _products.value = listOf(it)
                        }
                    } else {
                    }
                }
                .addOnFailureListener { exception ->
                }
        }
    }
    fun postRental(rental: Rental, onSuccess: () -> Unit, onError: (String) -> Unit) {
        firestore.collection("rentals")
            .add(rental)
            .addOnSuccessListener { documentReference ->
                onSuccess.invoke()
            }
            .addOnFailureListener { e ->
                onError.invoke("Failed to post rental: ${e.message}")
            }
    }
}
