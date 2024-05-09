package com.example.restaurante

//Importação de classes
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
//Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Carregar o layout da tela
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Uso do OnClickListener como botão de entrar
        binding.buttonEntrar.setOnClickListener {
            //Criação de variáveis de usuário e senha
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            //Verificar se o usuário e a senha são aos valores configurados
            if (username.equals("username") && password.equals("123")) {
                // Se correto criar um Intent para MainActivity e começar uma serie de ações
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username) //Passar o nome de usuário para MainActivity
                startActivity(i)
                finish() // Acabar a atividade evitando que o usuário volte com o botão de voltar
            } else {
                // Se não, exibir uma mensagem de erro com Toast
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}