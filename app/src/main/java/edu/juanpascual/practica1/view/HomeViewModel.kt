package edu.juanpascual.practica1.view

import android.content.Context
import androidx.lifecycle.ViewModel
import edu.juanpascual.practica1.db.HistoricoDbHelper
import edu.juanpascual.practica1.model.Persona
import edu.juanpascual.practica1.model.Registro

class HomeViewModel: ViewModel() {
    private lateinit var dbHelper: HistoricoDbHelper

    fun guardarRegistro(context: Context, persona: Persona) {
        dbHelper = HistoricoDbHelper(context)
        val registro = Registro(persona)
        dbHelper.insertRegistro(registro)
    }

}