package com.example.zerentapp.presentation.screen.Profil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zerentapp.data.sharedPref.SharedPreferencesManager
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class Profil(
    val id : String,
    val DisplayName: String,
    val Title: String,
)
@HiltViewModel
class ProfilViewModel @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val sharedPreferencesManager: SharedPreferencesManager
) : ViewModel() {

    private val _users = MutableStateFlow<List<Profil>>(emptyList())
    val users: StateFlow<List<Profil>> = _users

    private val email: String = sharedPreferencesManager.email ?: ""

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            firestore.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnSuccessListener { result ->
                    val userData = result.documents.mapNotNull { document ->
                        document.toObject(Profil::class.java)?.copy(id = document.id)
                    }
                    _users.value = userData
                }
                .addOnFailureListener { exception ->
                }
        }
    }
}