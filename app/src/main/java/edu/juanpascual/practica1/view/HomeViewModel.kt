package edu.juanpascual.practica1.view

import android.util.Log
import androidx.lifecycle.ViewModel
import edu.juanpascual.practica1.model.Persona
import edu.juanpascual.practica1.model.Registro
import edu.juanpascual.practica1.utils.Persistencia

class HomeViewModel : ViewModel() {
    fun guardarRegistro(persona: Persona) {
        val registro = Registro(persona)
        Persistencia().guardar(registro)
    }

}