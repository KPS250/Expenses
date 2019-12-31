package io.kustard.expenses.data

import io.kustard.expenses.model.Expense
import java.util.*
import kotlin.collections.ArrayList

object ExpenseMockHelper {

    val mockExpenseData: List<Expense>
        get() {
            val list = ArrayList<Expense>()
            for (i in 0..10) {
                val expense = Expense("Delhi Travel",  Calendar.getInstance().time,"Test", "TM Expenses", 100)
                list.add(expense)
            }
            return list
        }
}
