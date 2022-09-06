package com.example.aplicationangel

import android.app.DatePickerDialog
import android.content.Context
import android.widget.EditText
import java.util.*


class DatePickerAlert(private val ctx: Context) {
    fun show(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR) - 18
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            ctx,
            { datePicket, y, m, d ->
                editText.setText("$d/${m+1}/$y")
            },
            year,
            month,
            day
        )
        calendar.set(Calendar.YEAR, year)
        datePickerDialog.datePicker.maxDate = calendar.timeInMillis
        calendar.set(Calendar.YEAR, 1982)
        datePickerDialog.datePicker.minDate = calendar.timeInMillis
        datePickerDialog.show()
    }
}