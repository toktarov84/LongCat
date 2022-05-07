package com.example.thelengthofalongcat

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thelengthofalongcat.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                try {
                    when {
                        editTextNumber.text.isEmpty() -> editTextNumber.setHint("Введите длинну длиннокота!")
                        radioMeters.isChecked         -> toMeters()
                        radioParrots.isChecked        -> toParrots()
                        else -> {
                            editTextNumber.setText("")
                            editTextNumber.setHint("Куда конвертировать?")
                        }
                    }
                } catch (e: Exception) {
                    editTextNumber.setText("")
                    editTextNumber.setHint("Введите длинну длиннокота!")
                }
            }
        }
    }

    private fun ActivityMainBinding.toMeters() {
        editTextNumber.setText("${editTextNumber.text.toString().toDouble() / 7.6}")
    }

    private fun ActivityMainBinding.toParrots() {
        editTextNumber.setText("${editTextNumber.text.toString().toDouble() * 7.6}")
    }
}
