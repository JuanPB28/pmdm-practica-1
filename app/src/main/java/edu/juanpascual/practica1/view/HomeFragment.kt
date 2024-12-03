package edu.juanpascual.practica1.view

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.Navigation
import edu.juanpascual.practica1.R
import edu.juanpascual.practica1.databinding.FragmentHomeBinding
import edu.juanpascual.practica1.model.Persona

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.buttonHistorico.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.navigateToHistorico)
        }
        binding.buttonCalcular.setOnClickListener {
            calcular()
        }
    }

    private fun hideKeyboard() {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    private fun calcular() {
        try {
            hideKeyboard()
            // Obtener los valores de altura y peso
            val altura = binding.textInputEditTextAltura.text.toString()
            val peso = binding.textInputEditTextPeso.text.toString()
            val seleccionado = binding.radioGroup.checkedRadioButtonId

            // Validar que los campos no estén vacíos
            if (altura.isEmpty() || peso.isEmpty()) {
                Toast.makeText(context, "Introduce altura y peso", Toast.LENGTH_SHORT).show()
                return
            }

            if (seleccionado == -1) {
                Toast.makeText(context, "Selecciona un género", Toast.LENGTH_SHORT).show()
                return
            }

            // Crear un objeto Persona con los valores
            val genero = binding.radioGroup.findViewById<RadioButton>(seleccionado).text.toString()
            val persona = Persona(peso.toDouble(), altura.toDouble(), genero)
            val imc = persona.getIMC()
            val calificacion = persona.getCalificacion()

            //Cambiar el valor de textViewResultado
            binding.textViewResultado.text = imc.toString()

            //Cambiar el valor de textViewResultadoEscrito
            binding.textViewResultadoEscrito.text = calificacion
        } catch (e: Exception) {
            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}
