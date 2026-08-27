package com.example.calculadoradescuento

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import com.example.calculadoradescuento.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnviar.setOnClickListener {
            val numeroIngresado = binding.etPrecio.text.toString().toDoubleOrNull()
            val numeroIngresado2= binding.etDescuento.text.toString().toDoubleOrNull()
            if (numeroIngresado == null) {
                // USO DE TOAST: Mensaje rápido si el campo está vacío
                Toast.makeText(
                    this, "Por favor, escribe un precio",
                    Toast.LENGTH_SHORT
                ).show()

            }
            else if(numeroIngresado2== null){
                Toast.makeText(
                    this,"Por favor, escribe el descuento", Toast.LENGTH_SHORT
                ).show()
            }
            else  {
                viewModel.calcularDescuento(numeroIngresado,numeroIngresado2)


                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("CLAVE_PRECIOFINAL", viewModel.precioFinal)
                    putExtra("CLAVE_AHORRO", viewModel.ahorro)
                }
                startActivity(intent)
            }


        }
    }


}