package edu.juanpascual.practica1.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.RadioButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
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
        binding.buttonCalcular.setOnClickListener {
            addPersona()
        }

        setupUI(binding.root, listOf(binding.textInputLayoutPeso, binding.textInputLayoutAltura))
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
                Snackbar.make(binding.root, "Introduce altura y peso", Snackbar.LENGTH_SHORT).show()
                return
            }

            if (seleccionado == -1) {
                Snackbar.make(binding.root, "Selecciona un género", Snackbar.LENGTH_SHORT).show()
                return
            }

            // Dialog para confirmar
            val builder = android.app.AlertDialog.Builder(requireContext())
            builder.setMessage("¿Quieres guardar los datos?")
            builder.setPositiveButton("Confirmar") { _, _ ->
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
                viewModel.guardarRegistro(requireContext(), persona)

                Snackbar.make(binding.root, "Guardado", Snackbar.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Cancelar") { _, _ ->
                Snackbar.make(binding.root, "Cancelado", Snackbar.LENGTH_SHORT).show()
            }

            val dialog = builder.create()
            dialog.show()

        } catch (e: Exception) {
            Snackbar.make(binding.root, "Error: ${e.message}", Snackbar.LENGTH_SHORT).show()
        }
    }

    // Función para ocultar el teclado
    private fun hideKeyboard(view: View) {
        val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    // Configura el cierre del teclado al tocar fuera de los TextInputLayout
    @SuppressLint("ClickableViewAccessibility")
    private fun setupUI(view: View, textInputLayouts: List<TextInputLayout>) {
        // Establecer un listener en cada vista para detectar los toques
        if (view !is TextInputLayout) {
            view.setOnTouchListener { v, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    // Oculta el teclado si es necesario
                    hideKeyboardIfNecessary(v, textInputLayouts)
                }
                false
            }
        }

        // Si la vista tiene hijos, configurar el listener para cada uno de ellos también
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val child = view.getChildAt(i)
                setupUI(child, textInputLayouts)
            }
        }
    }

    // Función para verificar si se tocó fuera del TextInputLayout
    private fun hideKeyboardIfNecessary(view: View, textInputLayouts: List<TextInputLayout>) {
        var shouldHideKeyboard = true

        // Recorre la lista de TextInputLayouts para verificar si el toque ocurrió dentro de alguno
        for (textInputLayout in textInputLayouts) {
            val location = IntArray(2)
            textInputLayout.getLocationOnScreen(location)

            val x = location[0]
            val y = location[1]
            val width = textInputLayout.width
            val height = textInputLayout.height

            if (view.x > x && view.x < (x + width) && view.y > y && view.y < (y + height)) {
                // Si el toque ocurrió dentro de algún TextInputLayout, no oculta el teclado
                shouldHideKeyboard = false
                break
            }
        }

        if (shouldHideKeyboard) {
            hideKeyboard(view)
        }
    }

}
