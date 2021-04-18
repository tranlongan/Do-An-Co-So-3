package com.example.healthapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import com.example.healthapp.databinding.ActivityNewRecordBinding

class NewRecordActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {
    private var _binding: ActivityNewRecordBinding? = null
    private val binding get() = _binding!!

    var day = 0
    var month = 0
    var year = 0

    var saveDay = 0
    var saveMonth = 0
    var saveYear = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityNewRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  btn pick date
        binding.inputBirthDate.setOnClickListener {
            pickDate()
        }
        // btn sex
        binding.inputSex.setOnClickListener {
            val otherStrings = arrayOf("Nam", "Nữ", "Khác")
            var mBuilder = AlertDialog.Builder(this)
            mBuilder.setItems(otherStrings) { dialogInterface: DialogInterface, i: Int ->
                binding.inputSex.setText(otherStrings[i])
            }
            val dialog = mBuilder.create();
            dialog.show()
        }
        // btn next
        binding.btnNext.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    // pick birthday
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getDateTimeCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun pickDate() {
        getDateTimeCalendar()
        DatePickerDialog(this, this, year, month, day).show()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        saveDay = dayOfMonth
        saveMonth = dayOfMonth
        saveYear = year

        getDateTimeCalendar()
        var date = saveDay.toString() + "/" + saveMonth.toString() + "/" + saveYear.toString()
        binding.inputBirthDate.setText(date)
    }
    // end pick date


}