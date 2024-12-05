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

    fun getFecha(): String {
        return fecha
    }

    @Override
    override fun toString(): String {
        return "${getFecha()};" + "${persona.getGenero()};" + "${persona.getIMC()};" + persona.getCalificacion()
    }
}