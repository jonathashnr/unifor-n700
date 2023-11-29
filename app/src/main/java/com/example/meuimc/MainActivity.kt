package com.example.meuimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputAltura: EditText
    private lateinit var inputPeso: EditText
    private lateinit var btCalcular: Button
    private lateinit var tvIMCResult: TextView
    private lateinit var tvClassResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputAltura = findViewById(R.id.inputAltura)
        inputPeso = findViewById(R.id.inputPeso)
        btCalcular = findViewById(R.id.btCalcular)
        tvIMCResult = findViewById(R.id.tvIMCResult)
        tvClassResult = findViewById(R.id.tvClassResult)

        btCalcular.setOnClickListener {
            val altura = inputAltura.text.toString().toDouble()
            val peso = inputPeso.text.toString().toDouble()

            val imc = peso / (altura * altura)
            tvIMCResult.text = String.format("%.2f", imc)

            val classificacao = when {
                imc < 18.5 -> "Abaixo do peso"
                imc < 25 -> "Peso normal"
                imc < 30 -> "Sobrepeso"
                imc < 35 -> "Obesidade I"
                imc < 40 -> "Obesidade II"
                else -> "Obesidade III"
            }
            tvClassResult.text = classificacao
        }
    }
}