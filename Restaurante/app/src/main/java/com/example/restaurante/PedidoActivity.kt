package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //Carrega o layout da atividade usando o binding
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Obter a intent que começou a atividade
        val i = intent

        //Pega os valores de quantidade e converte para inteiros
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        //Cria string declarando quantidades e preços calculados
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        ////Define o texto do TextView no layout com o texto do resumo do pedido
        binding.textResumo.text = texto

    }
}