package com.cs473

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import androidx.core.view.setPadding
import androidx.core.widget.TextViewCompat
import com.cs473.databinding.ActivityMainBinding
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = "TableLayoutTest"
        binding.addButton.setOnClickListener {
            val androidVersion = binding.androidVersionEditText.text.toString()
            val androidCodeName = binding.androidCodeEditText.text.toString();
            if(androidVersion.isEmpty() || androidCodeName.isEmpty()){
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            addRowToTable(androidVersion, androidCodeName)
            binding.androidVersionEditText.text?.clear()
            binding.androidCodeEditText.text?.clear()
        }
        binding.tableLayout.isStretchAllColumns = true
    }

    private fun addRowToTable(androidVersion: String, androidCodeName: String) {
        val tableRow = TableRow(this)
        val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,  TableRow.LayoutParams.WRAP_CONTENT)
        layoutParams.bottomMargin = 10
        tableRow.layoutParams = layoutParams

        val androidVersionTv = TextView(this)
        androidVersionTv.layoutParams = layoutParams
        androidVersionTv.textSize = 18f
        androidVersionTv.setBackgroundResource(R.drawable.table_row_bg)
        androidVersionTv.setPadding(8)

        val androidCodeTv = TextView(this)
        androidVersionTv.layoutParams = layoutParams
        androidCodeTv.textSize = 18f
        androidCodeTv.setBackgroundResource(R.drawable.table_row_bg)
        androidCodeTv.setPadding(8)

        androidVersionTv.text = androidVersion
        androidCodeTv.text = androidCodeName
        tableRow.addView(androidVersionTv, 0)
        tableRow.addView(androidCodeTv, 1)

        binding.tableLayout.addView(tableRow)
    }
}