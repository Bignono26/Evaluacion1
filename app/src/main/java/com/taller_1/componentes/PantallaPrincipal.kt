package com.taller_1.componentes

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.taller_1.PantallaHonorariosActivity
import com.taller_1.PantallaRegularActivity

@Preview
@Composable
fun PantallaPrincipal() {
    val fontSize = 26.sp
    val fontWeight = FontWeight.Bold

    val contexto = LocalContext.current as ComponentActivity

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Calculadora de Sueldos",
                style = TextStyle(
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    color = Color(0,102,139)
                )
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        val intent = Intent(contexto, PantallaHonorariosActivity::class.java)
                        contexto.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Empleado Honorarios")
                }
                Button(
                    onClick = {
                        val intent = Intent(contexto, PantallaRegularActivity::class.java)
                        contexto.startActivity(intent)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Empleado Regular")
                }
            }
        }
    }
}