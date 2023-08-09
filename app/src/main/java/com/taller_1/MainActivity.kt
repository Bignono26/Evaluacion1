package com.taller_1

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.taller_1.componentes.PantallaEmpleadoHonorarios
import com.taller_1.componentes.PantallaPrincipal
import com.taller_1.modelos.EmpleadoRegular
import com.taller_1.ui.theme.Taller_1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaPrincipal()
                }
            }
        }
    }
}

class PantallaHonorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PantallaEmpleadoHonorarios()
                }
            }
        }
    }
}

@SuppressLint("SetTextI18n", "ResourceType")
class PantallaRegularActivity : AppCompatActivity() {
    fun volver(view: View) {
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.xml.pantalla_empleado_regular)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularSueldoLiquido)
        btnCalcular.setOnClickListener {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            val sueldoLiquido = findViewById<TextView>(R.id.tvSueldoLiquido)
            val sueldoBruto = findViewById<EditText>(R.id.editSueldoBruto)
            val sueldo = sueldoBruto.text.toString().toDoubleOrNull() ?: 0.0
            val empleadoRegular = EmpleadoRegular(sueldo)
            val sueldoLiquidoEmpleado = empleadoRegular.calcularLiquido()
            sueldoLiquido.text =
                "El sueldo líquido con un 20% de retención es $sueldoLiquidoEmpleado"
        }
    }
}