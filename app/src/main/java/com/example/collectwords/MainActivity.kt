package com.example.collectwords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.collectwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // important
    private val words = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonSave.setOnClickListener {
            val word = binding.editTextWord.text.trim().toString()
            if (word.isEmpty()) {
                binding.editTextWord.error = "No word"
                return@setOnClickListener
            }
            words.add(word)
            binding.textViewWords.text = "$word has been added"
            binding.editTextWord.setText("")
        }

        binding.buttonClear.setOnClickListener {
            words.clear()
            binding.textViewWords.text = "Words cleared"
        }

        binding.buttonShow.setOnClickListener {
            if (words.isEmpty()) {
                binding.textViewWords.text = "empty"
            } else {
                binding.textViewWords.text = words.toString()
            }
        }
    }


}