package edu.juanpascual.practica1.utils

import edu.juanpascual.practica1.model.Historico
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
        
    }

}