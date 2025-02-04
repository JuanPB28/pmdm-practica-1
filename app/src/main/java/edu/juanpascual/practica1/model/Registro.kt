package edu.juanpascual.practica1.model

import android.icu.util.Calendar

class Registro(private val persona: Persona) {
    private var fecha: String

    init {
        val date = Calendar.getInstance()
        this.fecha = "${date.get(Calendar.DAY_OF_MONTH)}-${date.get(Calendar.MONTH) + 1}-${date.get(Calendar.YEAR)}"
    }

    constructor(persona: Persona, fecha: String) : this(persona) {
        this.fecha = fecha
    }

    fun getPersona(): Persona {
        return persona
    }

    private fun getFecha(): String {
        return fecha
    }

    fun getDia(): String {
        return fecha.split("-")[0]
    }

    fun getMes(): String {
        val stringMes = fecha.split("-")[1]

        return when (stringMes) {
            "1" -> "Enero"
            "2" -> "Febrero"
            "3" -> "Marzo"
            "4" -> "Abril"
            "5" -> "Mayo"
            "6" -> "Junio"
            "7" -> "Julio"
            "8" -> "Agosto"
            "9" -> "Septiembre"
            "10" -> "Octubre"
            "11" -> "Noviembre"
            "12" -> "Diciembre"
            else -> "Error"
        }
    }

    fun getAnyo(): String {
        return fecha.split("-")[2]
    }

    @Override
    override fun toString(): String {
        return "${getFecha()};" + "${persona.getPeso()};" + "${persona.getAltura()};" + persona.getGenero()
    }
}