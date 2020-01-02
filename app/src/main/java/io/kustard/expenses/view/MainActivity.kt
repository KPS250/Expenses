package io.kustard.expenses.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import io.kustard.expenses.R
import io.kustard.expenses.databinding.ActivityMainBinding
import io.kustard.expenses.dependency.expenseModules
import io.kustard.expenses.model.Expense
import io.kustard.expenses.utils.ExpenseReadCallback
import io.kustard.expenses.utils.ExpeseCreateCallback
import io.kustard.expenses.utils.FirebaseHelper

import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

   lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(listOf(expenseModules))
        }

        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // val layoutManager = LinearLayoutManager(this)
        binding.contactList.layoutManager = get<LinearLayoutManager>()

        // val adapter = ArticleAdapter(articles)
        //var inserted = FirebaseHelper.createExpense()
        read()
    }



    fun read(){
        FirebaseHelper.getExpenses(object : ExpenseReadCallback {
            override fun ExpenseRead(list: ArrayList<Expense>) {
                Log.d("CALLBACK", list.size.toString())
                binding.contactList.adapter = ExpenseAdapter(list) //get<ExpenseAdapter>(list)
            }
        })
    }

    fun gotoCreateForm(view: View){
        var intent = Intent(this, ExpenseForm::class.java)
        startActivity(intent)
    }
}
