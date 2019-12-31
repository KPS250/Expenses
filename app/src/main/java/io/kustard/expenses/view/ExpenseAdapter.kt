package io.kustard.expenses.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.kustard.expenses.R
import io.kustard.expenses.databinding.RowExpenseBinding
import io.kustard.expenses.model.Expense
import io.kustard.expenses.viewmodel.ExpenseViewModel

class ExpenseAdapter(private val mExpenses: List<Expense>) : RecyclerView.Adapter<ExpenseAdapter.BindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding = DataBindingUtil.inflate<RowExpenseBinding>(
            LayoutInflater.from(parent.context),
            R.layout.row_expense, parent, false)

        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val binding = holder.binding
        binding.evm =  ExpenseViewModel(mExpenses[position])
    }

    override fun getItemCount(): Int {
        return mExpenses.size
    }

    class BindingHolder(val binding: RowExpenseBinding) : RecyclerView.ViewHolder(binding.mainLayout)
}