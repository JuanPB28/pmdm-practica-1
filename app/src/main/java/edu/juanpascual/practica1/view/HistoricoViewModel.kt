package edu.juanpascual.practica1.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.juanpascual.practica1.model.Registro
import edu.juanpascual.practica1.utils.Persistencia

class HistoricoViewModel : ViewModel() {

    private val _historico = MutableLiveData<MutableList<Registro>>()

    val historico: LiveData<MutableList<Registro>> get() = _historico

    init {
        _historico.value = Persistencia().cargar()
    }

    fun updateItems(newItems: MutableList<Registro>) {
        _historico.value = newItems
    }
}