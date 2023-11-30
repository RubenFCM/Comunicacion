package com.example.comunicacionactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CondicionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_condiciones)
        val bundle:Bundle = intent.extras!!
        val tv_fulanito = findViewById<TextView>(R.id.tv_fulanito)
        tv_fulanito.text= "Hola ${bundle.getString("Nombre")} ¿Quieres aceptar los términos?"

        var btn_aceptar = findViewById<Button>(R.id.btn_aceptar)
        var btn_rechazar = findViewById<Button>(R.id.btn_rechazar)
        btn_aceptar.setOnClickListener { navigateToMainActivity(bundle,"confirmado") }
        btn_rechazar.setOnClickListener { navigateToMainActivity(bundle,"rechazado") }


    }

    private fun navigateToMainActivity(bundle: Bundle, estado:String) {
        val intent = Intent(this,MainActivity::class.java)
        if (estado.equals("confirmado")){
            bundle.putString("Resultado","Has aceptado los términos")
            intent.putExtras(bundle)
            startActivity(intent)
        }
        if (estado.equals("rechazado")){
            bundle.putString("Resultado","Has rechazado los términos")
            intent.putExtras(bundle)
            startActivity(intent)
        }

    }
}