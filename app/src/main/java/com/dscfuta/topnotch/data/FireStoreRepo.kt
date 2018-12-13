package com.dscfuta.topnotch.data

import android.content.Context
import com.dscfuta.topnotch.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

/**
 * Created by Big-Nosed Developer on the Edge of Infinity.
 */
class FireStoreRepo() {

    private val fireStore = FirebaseFirestore.getInstance()

    //Retrieves firestore instance
    fun getFireStoreInstance() = fireStore

    //Retrieves the the requests
    fun getUserRequestCollection() = fireStore.collection("Users Request")

    fun deleteRequest(path: String, ifSuccessful: () -> Unit, ifNotSuccessful: (exception: String) -> Unit){
        getUserRequestCollection().document(path).delete().addOnCompleteListener {
            if(it.isSuccessful){
                ifSuccessful()
            }
            else{
                ifNotSuccessful(it.exception!!.localizedMessage)
            }
        }
    }
}