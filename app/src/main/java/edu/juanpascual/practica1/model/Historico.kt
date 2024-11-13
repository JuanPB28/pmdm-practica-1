package edu.juanpascual.practica1.model

class Historico {
    private var listaRegistros = mutableListOf<Registro>()

    fun addRegistro(registro: Registro) {
        listaRegistros.add(registro)
    }

    fun getRegistros(): List<Registro> {
        return listaRegistros
    }


}