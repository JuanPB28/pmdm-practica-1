package edu.juanpascual.practica1.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import edu.juanpascual.practica1.R
import edu.juanpascual.practica1.databinding.FragmentHistoricoBinding

class HistoricoFragment : Fragment() {

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
        adapter = HistoricoAdapter(viewModel.historico.value ?: mutableListOf())
        binding.recyclerView.adapter = adapter
        setListeners()

        viewModel.historico.observe(viewLifecycleOwner, Observer { items -> adapter.setItems(items) })

        return binding.root
    }

    private fun setListeners() {
        binding.buttonBack.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.navigateToHome)
        }
    }
}