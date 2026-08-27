package com.example.calculadoradescuento

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val precioFinal = intent.getDoubleExtra("CLAVE_PRECIOFINAL",0.0)
        val ahorro= intent.getDoubleExtra("CLAVE_AHORRO",0.0)
        val mensaje = findViewById<TextView>(R.id.tvMensaje)

        if(ahorro> 50){
            mensaje.text= "Felicidades ahorraste más de 50 soles\n Ahorraste: S/.$ahorro\n Tu total a pagar es: S/.$precioFinal"


        }else{
            mensaje.text="Ahorraste: S/.$ahorro.\n Tu total a pagar es: $precioFinal "
        }


    }
}