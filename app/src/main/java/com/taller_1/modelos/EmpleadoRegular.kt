package com.taller_1.modelos

class EmpleadoRegular(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val porcentajeDescuento = 0.2
        return sueldoBruto * (1 - porcentajeDescuento)
    }
}