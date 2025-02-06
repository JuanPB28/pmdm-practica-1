package edu.juanpascual.practica1.view

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.juanpascual.practica1.db.HistoricoDbHelper
import edu.juanpascual.practica1.model.Registro

class HistoricoViewModel : ViewModel() {
    private lateinit var dbHelper: HistoricoDbHelper

    private val _historico = MutableLiveData<MutableList<Registro>>()

    val historico: LiveData<MutableList<Registro>> get() = _historico

    fun loadItems(context: Context) {
        dbHelper = HistoricoDbHelper(context)
        _historico.value = dbHelper.getAllRegistros()
    }

    fun deleteItem(context: Context, item: Registro) {
        dbHelper = HistoricoDbHelper(context)

        val items = _historico.value ?: mutableListOf()
        items.remove(item)
        _historico.value = items

        dbHelper.deleteRegistro(item.getId())
    }
}