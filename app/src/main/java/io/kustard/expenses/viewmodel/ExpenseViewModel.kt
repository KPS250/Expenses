package io.kustard.expenses.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import io.kustard.expenses.BR
import io.kustard.expenses.model.Expense
import java.util.*

class ExpenseViewModel(private val expense: Expense) : BaseObservable() {

    var title: String?
        @Bindable
        get() = expense.title
        set(title) {
            expense.title = title
            notifyPropertyChanged(BR.title)
        }

    var date: Date?
        @Bindable
        get() = expense.date
        set(date) {
            expense.date = date
            notifyPropertyChanged(BR.date)
        }

    var project: String?
        @Bindable
        get() = expense.project
        set(project) {
            expense.project = project
            notifyPropertyChanged(BR.project)
        }

    var description: String?
        @Bindable
        get() = expense.description
        set(description) {
            expense.description = description
            notifyPropertyChanged(BR.description)
        }

    var amount: Int?
        @Bindable
        get() = expense.amount
        set(amount) {
            expense.amount = amount
            notifyPropertyChanged(BR.amount)
        }
}
