package com.example.juros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)

        setSupportActionBar(findViewById(R.id.toolbar2))
        val montante = findViewById<TextView>(R.id.txtMont)
        val valor = findViewById<TextView>(R.id.txtTotal)
        val parcela = findViewById<TextView>(R.id.txtParcela)
        val valormont = intent.getDoubleExtra("calcmont", 0.0)
        val valortotal = intent?.getDoubleExtra("calcvalor", 0.0)
        val valorparcela = intent?.getDoubleExtra("calcparcela", 0.0)
        montante.text = valormont.toString()
        valor.text = valortotal.toString()
        parcela.text = valorparcela.toString()
    }
}
