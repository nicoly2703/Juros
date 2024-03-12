package com.example.juros

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun calcularSimples(view: View) {
        val aa = findViewById<RadioButton>(R.id.radioAa)
        val Financiamento = findViewById<EditText>(R.id.edtFin)
        val Juros = findViewById<EditText>(R.id.edtJuros)
        val Tempo = findViewById<EditText>(R.id.edtTempo)
        val financiamento = Financiamento?.text.toString().toDouble()
        var taxa = Juros?.text.toString().toDouble()
        val tempo = Tempo?.text.toString().toDouble()
        var calcmont = 0.0
        var calcvalor = 0.0
        var calcparcela = 0.0
        if (aa.isChecked) {
            taxa=taxa / 12.0/100.0
            Toast.makeText(this,"$taxa",LENGTH_SHORT)
            calcmont = financiamento + (financiamento * taxa * tempo)
            calcvalor = calcmont - financiamento
            calcparcela = calcmont / tempo
        } else {
            taxa=taxa/100.0
            Toast.makeText(this,"$taxa",LENGTH_SHORT)
            calcmont = financiamento + (financiamento * taxa * tempo)
            calcvalor = calcmont - financiamento
            calcparcela = calcmont / tempo
        }

        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("calcmont", calcmont)
            putExtra("calcvalor", calcvalor)
            putExtra("calcparcela", calcparcela)
        }
        startActivity(intent)
    }

    fun calcularComposto(view: View) {
        val aa = findViewById<RadioButton>(R.id.radioAa)
        val edtfinanciamento = findViewById<EditText>(R.id.edtFin)
        val edtjuros = findViewById<EditText>(R.id.edtJuros)
        val edttempo = findViewById<EditText>(R.id.edtTempo)
        val financiamento = edtfinanciamento?.text.toString().toDouble()
        var taxa = edtjuros?.text.toString().toDouble()
        val tempo = edttempo?.text.toString().toDouble()
        var calcmont = 0.0
        var calcvalor = 0.0
        var calcparcela = 0.0
        if (aa.isChecked){
            taxa = taxa/100.0
            taxa = ((1+taxa).pow(1 / 12.0))-1
            Toast.makeText(this,"$taxa",LENGTH_SHORT).show()
            calcmont = financiamento * (1+taxa).pow(tempo)
            calcvalor = calcmont - financiamento
            calcparcela = calcmont / tempo
        }
        else {
            taxa = taxa/100.0
            Toast.makeText(this,"$taxa",LENGTH_SHORT).show()
            val taxa1=(1.0+taxa).pow(tempo)-1
            calcmont = financiamento * (1+taxa).pow(tempo)
            calcvalor = calcmont - financiamento
            calcparcela = calcmont / tempo
        }
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra("calcmont", calcmont)
            putExtra("calcvalor", calcvalor)
            putExtra("calcparcela", calcparcela)
        }
        startActivity(intent)
    }

}