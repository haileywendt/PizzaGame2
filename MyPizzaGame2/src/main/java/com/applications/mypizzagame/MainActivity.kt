package com.applications.mypizzagame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diameterPizza1 = findViewById<EditText>(R.id.diameterPizza1)
        val pricePizza1 = findViewById<EditText>(R.id.pricePizza1)
        val diameterPizza2 = findViewById<EditText>(R.id.diameterPizza2)
        val pricePizza2 = findViewById<EditText>(R.id.pricePizza2)
        val calculateButton = findViewById<Button>(R.id.calculateButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        calculateButton.setOnClickListener {
            val pricePerSqInchPizza1 = calculatePricePerSquareInch(diameterPizza1.text.toString().toDouble(), pricePizza1.text.toString().toDouble())
            val pricePerSqInchPizza2 = calculatePricePerSquareInch(diameterPizza2.text.toString().toDouble(), pricePizza2.text.toString().toDouble())

            val result = if (pricePerSqInchPizza1 < pricePerSqInchPizza2 || pricePerSqInchPizza1 == pricePerSqInchPizza2) {
                "Pizza 1 is the better buy.\nPrice per square inch: $pricePerSqInchPizza1"
            } else {
                "Pizza 2 is the better buy.\nPrice per square inch: $pricePerSqInchPizza2"
            }

            resultTextView.text = result
        }
    }

    private fun calculatePricePerSquareInch(diameter: Double, price: Double): Double {
        val radius = diameter / 2
        val area = PI * radius * radius
        return price / area
    }
}