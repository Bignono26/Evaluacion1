package com.taller_1.modelos

class EmpleadoHonorarios(sueldoBruto: Double) : Empleado(sueldoBruto) {
    override fun calcularLiquido(): Double {
        val porcentajeDescuento = 0.13
        return sueldoBruto * (1 - porcentajeDescuento)
    }
}