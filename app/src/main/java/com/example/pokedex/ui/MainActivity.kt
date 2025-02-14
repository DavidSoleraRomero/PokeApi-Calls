package com.example.pokedex.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.pokedex.R
import com.example.pokedex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.callPokemonApiButton.setOnClickListener {
            lifecycleScope.launch {
                val pokemonList = viewModel.callPokeApi()
                var pokemonResponseText: String = ""
                pokemonList.forEach {
                    p ->
                    pokemonResponseText +=
                            "${p.name.replaceFirstChar { it.uppercase() }} " +
                            " - " +
                            "${p.url}\n"
                }
                binding.pokemonResponse.text = pokemonResponseText
            }
        }

    }
}