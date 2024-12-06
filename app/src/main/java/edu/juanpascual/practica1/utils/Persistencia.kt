package edu.juanpascual.practica1.utils

import android.content.Context
import android.os.Environment
import android.util.Log
import edu.juanpascual.practica1.model.Persona
import edu.juanpascual.practica1.model.Registro
import java.io.File

class Persistencia() {
    private val FICHERO = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).absolutePath + "/historico.txt"


    fun guardar(registro: Registro) {
        try {
            val fichero = File(FICHERO)
            if (!fichero.exists()) {
                fichero.createNewFile()
            }
            fichero.appendText(registro.toString() + "\n")

            Log.i("Persistencia", "Registro guardado correctamente")
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun cargar(): MutableList<Registro> {
        val fichero = File(FICHERO)
        val historico = mutableListOf<Registro>()

        try {
            if (!fichero.exists()) {
                fichero.createNewFile()
            }

            fichero.forEachLine { linea ->
                val partes = linea.split(";")
                val persona = Persona(partes[1], partes[2].toDouble(), partes[3])
                val registro = Registro(persona, partes[0])
                historico.add(registro)
            }

            Log.i("Persistencia", "Registro cargado correctamente")
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return historico
    }

}