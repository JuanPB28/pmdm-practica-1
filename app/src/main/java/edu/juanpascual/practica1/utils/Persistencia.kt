package edu.juanpascual.practica1.utils

import edu.juanpascual.practica1.model.Historico
import edu.juanpascual.practica1.model.Persona
import edu.juanpascual.practica1.model.Registro
import java.io.File

class Persistencia(val historico: Historico) {
    private val FICHERO = "historico.txt"

    fun guardarRegistro(registro: Registro) {
        val fichero = File(FICHERO)
        if (!fichero.exists()) {
            fichero.createNewFile()
        }

        val listaRegistros = historico.getRegistros()
        listaRegistros.forEach { registro -> fichero.appendText(registro.toString()) }
    }

    fun cargarRegistros() {
        val fichero = File(FICHERO)
        if (!fichero.exists()) {
            fichero.createNewFile()
            return
        }
        // TODO: Modificar siguiendo las indicaciones del enunciado y las
        fichero.forEachLine { linea ->
            val partes = linea.split(",")
            val persona = Persona(partes[1].toDouble(), partes[2].toDouble(), partes[3])
            val registro = Registro(persona, partes[0])
            historico.addRegistro(registro)
        }

    }

}