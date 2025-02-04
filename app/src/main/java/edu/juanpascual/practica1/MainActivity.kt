package edu.juanpascual.practica1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.google.android.material.tabs.TabLayout
import edu.juanpascual.practica1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configurar los clics de las pestañas

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        binding.fragmentContainerView.findNavController().navigate(R.id.navigateToHome)
                    }
                    1 -> {
                        binding.fragmentContainerView.findNavController().navigate(R.id.navigateToHistorico)
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // No es necesario implementar
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // No es necesario implementar
            }
        })

    }
}