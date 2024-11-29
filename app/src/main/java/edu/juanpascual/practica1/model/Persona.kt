package edu.juanpascual.practica1.model

class Persona(private val peso: Double, private val altura: Double, private val genero: String) {
    private var imc: Double
    private var calificacion: String

    init {
        imc = calcularIMC()
        calificacion = obtenerCalificacion()
    }

    fun getPeso(): Double {
        return peso

    }

    fun getAltura(): Double {
        return altura
    }

    fun getGenero(): String {
        return genero
    }

    fun getIMC(): Double {
        return imc
    }

    fun getCalificacion(): String {
        return calificacion
    }

    private fun obtenerCalificacion(): String {
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

    private fun calcularIMC(): Double {
        val alturaMetros = altura / 100
        return peso / (alturaMetros * alturaMetros)
    }

//    private fun calcularIMC(altura: String, peso: String): Double {
//        val alturaDouble = Math.round(altura.toDouble() * 100) / 10000.0
//        val pesoDouble = Math.round(peso.toDouble() * 100) / 100.0
//        val imc = pesoDouble / (alturaDouble * alturaDouble)
//        return Math.round(imc * 100) / 100.0
//    }

//    fun onClickCalcular(view: View) {
//        try {
//            closeKeyboard()
//            val altura = binding.textInputEditTextAltura.text.toString()
//            val peso = binding.textInputEditTextPeso.text.toString()
//            val seleccionado = binding.radioGroup.checkedRadioButtonId
//
//
//            if (altura.isEmpty() || peso.isEmpty()) {
//                Toast.makeText(this, "Introduce altura y peso", Toast.LENGTH_SHORT).show()
//                return
//            }
//
//            if (seleccionado == -1) {
//                Toast.makeText(this, "Selecciona un género", Toast.LENGTH_SHORT).show()
//                return
//            }
//
//            val imc = calcularIMC(altura, peso)
//            val genero = findViewById<RadioButton>(seleccionado).text.toString()
//
//            //Cambiar el valor de textViewResultado
//            binding.textViewResultado.text = imc.toString()
//
//            //Cambiar el valor de textViewResultadoEscrito
//            binding.textViewResultadoEscrito.text = imcToString(imc, genero)
//        } catch (e: Exception) {
//            Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_LONG).show()
//        }
//    }

}