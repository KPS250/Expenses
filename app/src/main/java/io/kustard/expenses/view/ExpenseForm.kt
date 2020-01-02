package io.kustard.expenses.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import io.kustard.expenses.R
import io.kustard.expenses.databinding.ActivityExpenseFormBinding
import io.kustard.expenses.model.Expense
import io.kustard.expenses.utils.ExpeseCreateCallback
import io.kustard.expenses.utils.FirebaseHelper
import io.kustard.expenses.viewmodel.ExpenseViewModel
import java.util.*

class ExpenseForm : AppCompatActivity() {

    lateinit var binding: ActivityExpenseFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_expense_form)

        binding = DataBindingUtil.setContentView<ActivityExpenseFormBinding>(this, R.layout.activity_expense_form)
        var expense = Expense("Delhi Travel",  Calendar.getInstance().time,"Test", "TM Expenses", 100)
        var expenseViewModel = ExpenseViewModel(expense)
        binding.evmForm = expenseViewModel
    }

    fun createExpense(view : View){

        FirebaseHelper.createExpense(object : ExpeseCreateCallback {
            override fun ExpenseCreate() {
                finish()
            }
        })
    }
}
