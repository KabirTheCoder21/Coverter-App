package com.example.unitcon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val currency: CardView = findViewById(R.id.currency)
        val weight: CardView = findViewById(R.id.weight)
        val time: CardView = findViewById(R.id.time)
        val length: CardView = findViewById(R.id.length)
        val area: CardView = findViewById(R.id.area)
        val temperature: CardView = findViewById(R.id.temperature)
       //clickListner for currency screen
        val clickListner1 : View.OnClickListener = View.OnClickListener { view->
            when (view.id) {
                R.id.currency -> goToCurrencyScreen()
                R.id.weight-> goToWeightScreen()
                R.id.time-> goToTimeScreen()
                R.id.length-> goToLengthScreen()
                R.id.area-> goToAreaScreen()
                R.id.temperature-> goToTemperatureScreen()
            }
        }
        currency.setOnClickListener(clickListner1)
        //clickListner for weight screen

        weight.setOnClickListener(clickListner1)

        //clickListner for time screen
        time.setOnClickListener(clickListner1)
        //clickListner for length screen
        length.setOnClickListener(clickListner1)
        //clickListner for area screen
        area.setOnClickListener(clickListner1)
        //clickListner for temperature screen
        temperature.setOnClickListener(clickListner1)
    }

    private fun goToTemperatureScreen() {
        val intent = Intent(this,temperature::class.java)
        startActivity(intent)
    }

    private fun goToAreaScreen() {
        val intent = Intent(this,area::class.java)
        startActivity(intent)
    }

    private fun goToLengthScreen() {
        val intent = Intent(this,length::class.java)
        startActivity(intent)
    }

    private fun goToTimeScreen() {
        val intent = Intent(this,time::class.java)
        startActivity(intent)
    }

    private fun goToWeightScreen() {
        val intent = Intent(this,weight::class.java)
        startActivity(intent)
    }

    private fun goToCurrencyScreen() {
        val intent = Intent(this,currency::class.java)
        startActivity(intent)
    }

}