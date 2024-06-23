package com.example.zerentapp.presentation.screen.Request
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Request(
    val id: String = "",
    val title: String = "",
    val deskripsi: String = "",
    val kategori: String = "",
    val priceEnd: String = "",
    val priceStart: String = "",
    val userName: String = "",
    val image: String = "",
    val waktu: String = "",
)

@HiltViewModel
class RequestViewModel @Inject constructor(
    private val firestore: FirebaseFirestore
) : ViewModel() {
    private val _requests = MutableStateFlow<List<Request>>(emptyList())
    val requests: StateFlow<List<Request>> = _requests

    init {
        fetchRequests()
    }

    private fun fetchRequests() {
        viewModelScope.launch {
            firestore.collection("requests").get()
                .addOnSuccessListener { result ->
                    val productList = result.documents.mapNotNull { document ->
                        document.toObject(Request::class.java)?.copy(id = document.id)
                    }
                    _requests.value = productList
                }
                .addOnFailureListener { exception ->
                }
        }
    }

    fun postRequest(request: Request, onSuccess: () -> Unit, onError: (String) -> Unit) {
        firestore.collection("requests")
            .add(request)
            .addOnSuccessListener { documentReference ->
                onSuccess.invoke()
            }
            .addOnFailureListener { e ->
                onError.invoke("Failed to post request: ${e.message}")
            }
    }
}
