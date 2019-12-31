package io.kustard.expenses.model

import java.util.*

class Expense(
        title :String,
        date: Date,
        project: String,
        description:String,
        amount:Int) {
    var title : String? = title
    var date : Date? = date
    var project : String? = project
    var description : String? = description
    var amount : Int? = amount
}