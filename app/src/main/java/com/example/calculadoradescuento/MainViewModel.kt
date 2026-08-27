package com.example.calculadoradescuento

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    var precioFinal: Double=0.0

    var ahorro: Double=0.0

    fun calcularDescuento(precio: Double,descuento: Double){
        ahorro=(precio*descuento)/100
        precioFinal=precio-ahorro

    }

    }
