package com.taller_1.modelos

abstract class Empleado(var sueldoBruto: Double) {
    abstract fun calcularLiquido(): Double
}