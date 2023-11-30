package com.example.comunicacionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    private lateinit var et_nombre : EditText
    private lateinit var tv_resultado : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var bundle = Bundle()
        intent.putExtras(bundle)
        var btn_verificar = findViewById<Button>(R.id.btn_verificar)
        btn_verificar.setOnClickListener{navigateToCondicionesActivity(bundle)}
        et_nombre = findViewById(R.id.et_nombre)
        tv_resultado = findViewById(R.id.tv_resultado)
        bundle = intent.extras!!
        tv_resultado.text = bundle.getString("Resultado")

    }
    private fun navigateToCondicionesActivity(bundle:Bundle){
        val intent = Intent(this,CondicionesActivity::class.java)
        var nombre = et_nombre.text.toString()
        bundle.putString("Nombre",nombre)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}