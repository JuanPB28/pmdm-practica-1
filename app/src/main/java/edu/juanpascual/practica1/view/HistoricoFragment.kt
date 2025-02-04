package edu.juanpascual.practica1.view

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import edu.juanpascual.practica1.databinding.FragmentHistoricoBinding
import edu.juanpascual.practica1.model.Registro
import edu.juanpascual.practica1.utils.RegistroClickListener

class HistoricoFragment : Fragment(), RegistroClickListener {

    companion object {
        fun newInstance() = HistoricoFragment()
    }

    private lateinit var binding: FragmentHistoricoBinding
    private lateinit var adapter: HistoricoAdapter
    private val viewModel: HistoricoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricoBinding.inflate(inflater, container, false)
        adapter = HistoricoAdapter(viewModel.historico.value ?: mutableListOf(), this)
        binding.recyclerView.adapter = adapter

        // Observar los cambios en el LiveData
        viewModel.historico.observe(viewLifecycleOwner, Observer { items -> adapter.setItems(items) })

        return binding.root
    }

    override fun onItemClicked(registro: Registro) {
        val calificacion = registro.getPersona().getCalificacion()
        val imc = registro.getPersona().getIMC()
        Snackbar.make(binding.root, calificacion + " " + "(${imc})", Snackbar.LENGTH_SHORT).show()
    }


}