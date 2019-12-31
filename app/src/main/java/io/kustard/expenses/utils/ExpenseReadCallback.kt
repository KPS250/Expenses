package io.kustard.expenses.utils

import io.kustard.expenses.model.Expense

interface ExpenseReadCallback {
    fun ExpenseRead(list: ArrayList<Expense>)
}