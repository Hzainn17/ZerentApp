package com.example.zerentapp.presentation.screen.PostingProduct

import android.net.Uri
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class PostingViewModel : ViewModel() {

    private val firestore = FirebaseFirestore.getInstance()
    private val storage = Firebase.storage

    fun saveProduct(
        nama: String,
        harga: String,
        deposit: String,
        kota: String,
        kecamatan: String,
        no: String,
        imageUri: String,
        deskripsi: String,
        jarak: String,
        rating: String,
        namaPenjual: String
    ) {
        val product = hashMapOf(
            "ProductNama" to nama,
            "ProductHarga" to harga,
            "deposit" to deposit,
            "kota" to kota,
            "kecamatan" to kecamatan,
            "no" to no,
            "productDesc" to deskripsi,
            "productDistance" to jarak,
            "productRating" to rating,
            "productPenjual" to namaPenjual
        )

        // Simpan data produk ke Firestore
        firestore.collection("products")
            .add(product)
            .addOnSuccessListener { documentReference ->
                // Handle success
                // Jika data berhasil disimpan ke Firestore, upload file gambar ke Firebase Storage
                uploadImageToStorage(documentReference.id, imageUri)
            }
            .addOnFailureListener { e ->
                // Handle failure
            }
    }

    private fun uploadImageToStorage(documentId: String, imageUri: String) {
        val storageRef = storage.reference
        val imageRef = storageRef.child("images/$documentId.jpg") // Path penyimpanan di Firebase Storage

        // Upload file gambar ke Firebase Storage
        val uploadTask = imageRef.putFile(Uri.parse(imageUri))

        uploadTask.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // File gambar berhasil diupload
                // Dapatkan URL download file gambar dari Firebase Storage
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    // Simpan URL download file gambar ke Firestore atau lakukan operasi lainnya
                    firestore.collection("products").document(documentId)
                        .update("productImage", uri.toString()) // Contoh: Simpan URL download ke Firestore
                        .addOnSuccessListener {
                            // Handle success
                        }
                        .addOnFailureListener {
                            // Handle failure
                        }
                }
            } else {
                // Handle failure
            }
        }
    }
}
