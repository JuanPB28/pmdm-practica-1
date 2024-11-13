package edu.juanpascual.practica1.model

import android.icu.util.Calendar

class Registro(private val persona: Persona) {
    private var fecha: String

    init {
        // TODO: Seguramente de problemas con la fecha como que al cargar el fichero todos los datos tengan la misma fecha, lidiar con el problema
        val date = Calendar.getInstance()
        this.fecha = "${date.get(Calendar.HOUR)}:${date.get(Calendar.MINUTE)}:${date.get(Calendar.SECOND)}-${date.get(Calendar.DAY_OF_MONTH)}/${date.get(Calendar.MONTH) + 1}/${date.get(Calendar.YEAR)}"
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

    // TODO: Modificar siguiendo las indicaciones del enunciado
    @Override
    override fun toString(): String {
        return "Fecha: ${getFecha()}, " +
                "Peso: ${persona.getPeso()}, " +
                "Altura: ${persona.getAltura()}, " +
                "IMC: ${persona.getIMC()}, " +
                "Calificación: ${persona.getCalificacion()}"
    }

}