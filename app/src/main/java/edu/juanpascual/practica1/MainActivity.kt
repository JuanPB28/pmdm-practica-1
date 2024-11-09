package edu.juanpascual.practica1

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import edu.juanpascual.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun calcularIMC(altura: String, peso: String): Double {
        val alturaDouble = Math.round(altura.toDouble() * 100) / 10000.0
        val pesoDouble = Math.round(peso.toDouble() * 100) / 100.0
        val imc = pesoDouble / (alturaDouble * alturaDouble)
        return Math.round(imc * 100) / 100.0
    }

    private fun imcToString(imc: Double, genero: String): String {
        val imcHombre = when {
            imc < 18.5 -> "Bajo peso"
            imc < 25 -> "Normal"
            imc < 30 -> "Sobrepeso"
            else -> "Obesidad"
        }

        val imcMujer = when {
            imc < 18.5 -> "Bajo peso"
            imc < 24 -> "Normal"
            imc < 29 -> "Sobrepeso"
            else -> "Obesidad"
        }

        return when (genero) {
            "Hombre" -> imcHombre
            "Mujer" -> imcMujer
            else -> "Error"
        }
    }

    // Método para cerrar el teclado
    private fun closeKeyboard() {
        // Obtener el InputMethodManager
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        // Ocultar el teclado desde la ventana actual (la que tiene el foco)
        inputMethodManager.hideSoftInputFromWindow(binding.root.windowToken, 0)
    }

    fun onClickCalcular(view: View) {
        try {
            closeKeyboard()
            val altura = binding.textInputEditTextAltura.text.toString()
            val peso = binding.textInputEditTextPeso.text.toString()
            val seleccionado = binding.radioGroup.checkedRadioButtonId


            if (altura.isEmpty() || peso.isEmpty()) {
                Toast.makeText(this, "Introduce altura y peso", Toast.LENGTH_SHORT).show()
                return
            }

            if (seleccionado == -1) {
                Toast.makeText(this, "Selecciona un género", Toast.LENGTH_SHORT).show()
                return
            }

            val imc = calcularIMC(altura, peso)
            val genero = findViewById<RadioButton>(seleccionado).text.toString()

            //Cambiar el valor de textViewResultado
            binding.textViewResultado.text = imc.toString()

            //Cambiar el valor de textViewResultadoEscrito
            binding.textViewResultadoEscrito.text = imcToString(imc, genero)
        } catch (e: Exception) {
            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}