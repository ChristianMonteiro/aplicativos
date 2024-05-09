package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash) // Definição do layout da atividade

        //Define atraso de 2 segundos antes de iniciar a próxima atividade
        Handler(Looper.getMainLooper()).postDelayed({
            //Pega a intent que iniciou a atividade
            val i = intent
            //Cria uma intent para próxima atividade
            val j = Intent(this,PedidoActivity::class.java)
            //Copia os extras da intent atual para próxima
            j.putExtras(i)
            // Inicia a próxima atividade
            startActivity(j)
        },2000) // 2000 milissegundos = 2 segundos de atraso
    }
}