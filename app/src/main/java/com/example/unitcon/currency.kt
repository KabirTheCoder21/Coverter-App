package com.example.unitcon

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import java.text.DecimalFormat

class currency : AppCompatActivity() {
    private lateinit var selectedUnitLayout: LinearLayout
    private lateinit var selectedUnitText : TextView
    private lateinit var editInput : EditText
    // private lateinit var resultText : TextView
    private lateinit var textResult : TextView
    private lateinit var resultTypeText : TextView
    private lateinit var selectedUnit : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currency)
        selectedUnitLayout = findViewById(R.id.selectType)
        selectedUnitText = findViewById(R.id.textSelect)
        editInput = findViewById(R.id.edit_input)
        textResult = findViewById(R.id.textResult)
        resultTypeText = findViewById(R.id.textResultType)
        selectedUnit = "INR"

        //searching alert dialog to appear for selection of input unit
        selectedUnitLayout.setOnClickListener()
        {
            showAlertDialog()
        }
        editInput.addTextChangedListener(){
            var resultText : String = " "
            var inputVal = editInput.text.toString()
            val df= DecimalFormat("#.###")
            if(inputVal.isNotEmpty())
            {
                val doubleInput = inputVal.toDouble()
                if(selectedUnit=="INR"){
                    resultText =df.format(doubleInput/81.63)
                    resultTypeText.text = "USD"
                }
                else{
                    resultText = df.format(doubleInput*81.63)
                    resultTypeText.text = "INR"
                }
                textResult.text= resultText
            }
        }
    }
    private fun showAlertDialog() {
        var alertDialog : AlertDialog.Builder = AlertDialog.Builder(this@currency)
        alertDialog.setTitle("Select Input Unit")
        val items = arrayOf("INR","USD")
        val checkedItems=-1
        alertDialog.setSingleChoiceItems(items,checkedItems,
            DialogInterface.OnClickListener()
            {
                    dialog,which->
                selectedUnit = items[which]
                selectedUnitText.setText(selectedUnit)
            })
        alertDialog.setPositiveButton(android.R.string.ok,
            DialogInterface.OnClickListener(){ dialog, which->
                dialog.dismiss()
            })
        val alert : AlertDialog = alertDialog.create()

        alertDialog.show()
    }
}