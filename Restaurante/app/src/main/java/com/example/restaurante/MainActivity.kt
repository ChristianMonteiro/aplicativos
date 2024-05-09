package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
    //Carrega o layout utilizando o binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Descobre o username pela intent e exibe uma saudação
        val username = intent.extras?.getString("username")
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        //Define um botão para encerrar a atividade
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        //Define um botão para a quantidade de pedidos, sendo uma atividade Splash
        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

        //Uma checkbox da Pizza que atualiza o valor de acordo com a quantidade
        //Valor visivel apenas com checkbox ativa
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        //Uma checkbox da Salada que atualiza o valor de acordo com a quantidade
        //Valor visivel apenas com checkbox ativa
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

        //Uma checkbox da Hamburguer que atualiza o valor de acordo com a quantidade
        //Valor visivel apenas com checkbox ativa
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}