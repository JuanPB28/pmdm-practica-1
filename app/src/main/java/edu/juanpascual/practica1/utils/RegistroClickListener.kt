package edu.juanpascual.practica1.utils

import edu.juanpascual.practica1.model.Registro

interface RegistroClickListener {
    fun onItemClicked(registro: Registro)
}