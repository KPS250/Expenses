package io.kustard.expenses.dependency

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import io.kustard.expenses.data.ExpenseMockHelper
import io.kustard.expenses.model.Expense
import io.kustard.expenses.view.ExpenseAdapter
import io.kustard.expenses.viewmodel.ExpenseViewModel

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var expenseModules = module {
    factory { LinearLayoutManager(androidContext()) }
    //factory { ExpenseAdapter(ExpenseMockHelper.mockExpenseData) }
    //factory { (item: ArrayList<Expense> ) -> ExpenseAdapter( get {item} ) }
    factory { (item: Expense) -> ExpenseViewModel(item) }
}

var firebaseModule = module {
    single { FirebaseFirestore.getInstance() }
}


