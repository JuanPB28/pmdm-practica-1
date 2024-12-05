package edu.juanpascual.practica1.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.juanpascual.practica1.databinding.RowHistoricoBinding
import edu.juanpascual.practica1.model.Registro

class HistoricoAdapter(private var items: MutableList<Registro>) : RecyclerView.Adapter<HistoricoAdapter.HistoricoViewHolder>() {
    class HistoricoViewHolder(val binding: RowHistoricoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricoViewHolder {
        val binding = RowHistoricoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoricoViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HistoricoViewHolder, position: Int) {
        holder.binding.textViewFecha.text = items[position].getFecha()
        holder.binding.textViewPersona.text = items[position].getPersona().getCalificacion()
    }
}