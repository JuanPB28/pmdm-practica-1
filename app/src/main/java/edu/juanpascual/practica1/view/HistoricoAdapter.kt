package edu.juanpascual.practica1.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.juanpascual.practica1.databinding.RowHistoricoBinding
import edu.juanpascual.practica1.model.Registro
import edu.juanpascual.practica1.utils.RegistroClickListener

class HistoricoAdapter(
    private var items: MutableList<Registro>,
    private val clickListener: RegistroClickListener
) : RecyclerView.Adapter<HistoricoAdapter.HistoricoViewHolder>() {

    class HistoricoViewHolder(val binding: RowHistoricoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowHistoricoBinding.inflate(layoutInflater, parent, false)
        return HistoricoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoricoViewHolder, position: Int) {
        // Establecer los valores en el ViewHolder
        holder.binding.textViewMes.text = items[position].getMes()
        holder.binding.textViewDia.text = items[position].getDia()
        holder.binding.textViewAnyo.text = items[position].getAnyo()
        holder.binding.textViewCalificacion.text = items[position].getPersona().getCalificacion()
        holder.binding.textViewGenero.text = items[position].getPersona().getGenero()
        holder.binding.textViewPeso.text = items[position].getPersona().getPeso().toString()
        holder.binding.textViewAltura.text = items[position].getPersona().getAltura().toString()
        holder.binding.textViewIMC.text = items[position].getPersona().getIMC().toString()

        // Configurar el click listener
        holder.binding.cardViewHistorico.setOnClickListener {
            clickListener.onItemClicked(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    fun setItems(newItems: MutableList<Registro>) {
        items = newItems
        notifyDataSetChanged()
    }

}