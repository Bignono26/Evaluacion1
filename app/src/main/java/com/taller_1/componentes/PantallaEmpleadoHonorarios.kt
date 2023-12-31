package com.taller_1.componentes

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taller_1.modelos.EmpleadoHonorarios

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PantallaEmpleadoHonorarios() {
    var sueldoBruto by remember { mutableStateOf("") }
    var sueldoLiquido by remember { mutableStateOf("") }
    val contexto = LocalContext.current as ComponentActivity

    Box {
        Button(
            modifier = Modifier.padding(20.dp),
            onClick = { contexto.finish() },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White
            )
        ) {
            Text("Volver atrás")
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Empleado a Honorarios",
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0,102,139)
                )
            )
            Spacer(modifier = Modifier.height(25.dp))
            TextField(
                placeholder = {
                    Text("Ingrese Sueldo Bruto")
                },
                value = sueldoBruto,
                onValueChange = { sueldoBruto = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        val sueldo = sueldoBruto.toDoubleOrNull() ?: 0.0
                        val sueldoLiquidoEmpleado = EmpleadoHonorarios(sueldo).calcularLiquido()
                        sueldoLiquido =
                            "El sueldo líquido con un 13% de retención es $sueldoLiquidoEmpleado"
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text("Calcular Sueldo Líquido")
                }
            }
            Text(
                text = sueldoLiquido,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}