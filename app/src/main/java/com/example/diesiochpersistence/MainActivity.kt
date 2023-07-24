package com.example.diesiochpersistence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diesiochpersistence.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btGuardar.setOnClickListener {
            val text = binding.edTexto.text.toString()
            val entero= binding.edEntero.text.toString().toInt()
            val decimal = binding.edDecimal.text.toString().toDouble()
            val switch = binding.switch1.isChecked
        }
    }

}