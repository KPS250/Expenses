package io.kustard.expenses.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.kustard.expenses.R
import io.kustard.expenses.utils.ExpeseCreateCallback
import io.kustard.expenses.utils.FirebaseHelper

class ExpenseForm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_form)
    }

    fun createExpense(view : View){



        FirebaseHelper.createExpense(object : ExpeseCreateCallback {
            override fun ExpenseCreate() {
                finish()
            }
        })
    }
}
