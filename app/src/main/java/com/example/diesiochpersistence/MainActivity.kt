package com.example.diesiochpersistence

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diesiochpersistence.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var asharePreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        asharePreferences = getSharedPreferences("cooki", Context.MODE_PRIVATE)
        setContentView(binding.root)

        binding.btGuardar.setOnClickListener {
            val texto = binding.edTexto.text.toString()
            val entero= binding.edEntero.text.toString().toInt()
            val decimal = binding.edDecimal.text.toString().toFloat()
            val boleano = binding.switch1.isChecked

            guardarDatos(texto, entero, decimal, boleano)
        }
        binding.btMostrar.setOnClickListener {
            mostrarDatos()
        }

        binding.btBorrar.setOnClickListener {
            borrarDatos()
        }
    }



    private fun guardarDatos(texto: String, entero: Int, decimal: Float, boleano: Boolean) {

        asharePreferences.edit().putString("miTexto",texto).apply()
        asharePreferences.edit().putInt("miEntero",entero).apply()
        asharePreferences.edit().putFloat("miDecimal",decimal).apply()
        asharePreferences.edit().putBoolean("miBoleano",boleano).apply()

    }
    private fun mostrarDatos() {
        val texto = asharePreferences.getString("miTexto","")
        val entero = asharePreferences.getInt("miEntero",0)
        val decimal = asharePreferences.getFloat("miDecimal",0.0f)
        val boleano = asharePreferences.getBoolean("miBoleano", false)

        binding.tvTexto.text = texto
        binding.tvDecimal.text = decimal.toString()
        binding.tvEntero.text = entero.toString()
        binding.switch1.isChecked = boleano

    }
    private fun borrarDatos(){
        binding.tvEntero.text =""
        binding.tvDecimal.text =""
        binding.tvTexto.text =""

        binding.edEntero.text.clear()
        binding.edDecimal.text.clear()
        binding.edTexto.text.clear()
        binding.switch1.isChecked = false


        asharePreferences.edit().clear().apply()
    }


}