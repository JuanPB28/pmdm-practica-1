package edu.juanpascual.practica1.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setListeners()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        permisos()
    }

    private fun setListeners() {
        binding.buttonHistorico.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.navigateToHistorico)
        }
        binding.buttonCalcular.setOnClickListener {
            addPersona()
        }
    }

    private fun permisos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                val intent = Intent(Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION)
                intent.data = Uri.parse("package:" + requireContext().packageName)
                startActivity(intent)
            }
        }
    }

    private fun addPersona() {
        try {
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

            // Guardar en el archivo
            viewModel.guardarRegistro(persona)

        } catch (e: Exception) {
            Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}
