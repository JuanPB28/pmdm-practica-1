package edu.juanpascual.practica1.model

import android.icu.util.Calendar

class Registro(private val persona: Persona) {
    private val fecha: Calendar = Calendar.getInstance()

    init {
        fecha.timeInMillis = System.currentTimeMillis()
    }

    fun getPersona(): Persona {
        return persona
    }

    fun getFecha(): Calendar {
        return fecha
    }

    // TODO: Modificar siguiendo las indicaciones del enunciado
    @Override
    override fun toString(): String {
        return "Fecha: ${fecha.get(Calendar.DAY_OF_MONTH)}/${fecha.get(Calendar.MONTH) + 1}/${fecha.get(Calendar.YEAR)} , " +
                "Peso: ${persona.getPeso()}, " +
                "Altura: ${persona.getAltura()}, " +
                "IMC: ${persona.getIMC()}, " +
                "Calificación: ${persona.getCalificacion()}"
    }

}