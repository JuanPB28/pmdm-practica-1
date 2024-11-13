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

}