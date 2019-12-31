package io.kustard.expenses.utils

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import io.kustard.expenses.model.Expense
import java.util.*
import kotlin.collections.ArrayList

object FirebaseHelper {

    @JvmStatic
    fun createExpense( expenseCreateCallback: ExpeseCreateCallback ) {
        val expense = Expense("Delhi Travel",  Calendar.getInstance().time,"Test", "TM Expenses", 100)
        val db = FirebaseFirestore.getInstance()
        db.collection("expenses")
            .add(expense)
            .addOnSuccessListener(OnSuccessListener<DocumentReference> { documentReference ->
                Log.d("TEST", "DocumentSnapshot added with ID: " + documentReference.id)
                expenseCreateCallback.ExpenseCreate()
            })
            .addOnFailureListener(OnFailureListener { e -> Log.w("TEST", "Error adding document", e) })
    }

    fun getExpenses( expenseReadCallback: ExpenseReadCallback ) {
        val db = FirebaseFirestore.getInstance()
        val expenses = ArrayList<Expense>()

        db.collection("expenses")
            .get()
            .addOnCompleteListener(OnCompleteListener<QuerySnapshot> { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        if (document.exists()) {
                            var temp = Expense(
                                document["title"].toString(),
                                document["date"] as Date,
                                document.data["project"].toString(),
                                document.data["description"].toString(),
                                (document.data["amount"] as Long).toInt()
                            )
                            expenses.add(temp)
                        }
                    }
                } else {
                    Log.w("TEST", "Error getting documents.", task.exception)
                }
                expenseReadCallback.ExpenseRead(expenses)
            })
    }
}