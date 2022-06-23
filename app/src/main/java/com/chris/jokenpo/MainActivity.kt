package com.chris.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var randomStr : String
        lateinit var resultado : String
        lateinit var derrota : String
        lateinit var vitoria : String
        lateinit var empate : String
        var randomInt : Int

        randomInt = Random.nextInt(0,2)


        val ivPadrao = findViewById<ImageView>(R.id.ivPadrao)
        val ivPedra = findViewById<ImageView>(R.id.ivPedra)
        var ivPapel = findViewById<ImageView>(R.id.ivPapel)
        val ivTesoura = findViewById<ImageView>(R.id.ivTesoura)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvBody = findViewById<TextView>(R.id.tvBody)


        derrota = "Você Perdeu =/"
        vitoria = "Você Ganhou =]"
        empate = "Empatou >.<"


        if (randomInt == 0) {
            randomStr = "Pedra"
        }
        else if (randomInt == 1) {
            randomStr = "Papel"
        }
        else {
            randomStr = "Tesoura"
        }

        ivPedra.setOnClickListener{
            if (randomStr == "Pedra") {
                resultado = empate
                ivPadrao.setImageResource((R.drawable.pedra))
            }
            if (randomStr == "Papel") {
                resultado = derrota
                ivPadrao.setImageResource((R.drawable.papel))
            }
            if (randomStr == "Tesoura") {
                resultado = vitoria
                ivPadrao.setImageResource((R.drawable.tesoura))
            }
            tvTitle.setText("O CPU escolheu ${randomStr}")
            tvBody.setText("Você escolheu Pedra!! ${resultado}")
            ivPapel.setVisibility(View.GONE)
            ivTesoura.setVisibility(View.GONE)
        }

        ivPapel.setOnClickListener{
            if (randomStr == "Pedra") {
                resultado = vitoria
                ivPadrao.setImageResource((R.drawable.pedra))
            }
            if (randomStr == "Papel") {
                resultado = empate
                ivPadrao.setImageResource((R.drawable.papel))
            }
            if (randomStr == "Tesoura") {
                resultado = derrota
                ivPadrao.setImageResource((R.drawable.tesoura))
            }
            tvTitle.setText("O CPU escolheu ${randomStr}")
            tvBody.setText("Você escolheu Pedra!! ${resultado}")
            ivPedra.setVisibility(View.GONE)
            ivTesoura.setVisibility(View.GONE)
        }

        ivTesoura.setOnClickListener{
            if (randomStr == "Pedra") {
                resultado = derrota
                ivPadrao.setImageResource((R.drawable.pedra))
            }
            if (randomStr == "Papel") {
                resultado = vitoria
                ivPadrao.setImageResource((R.drawable.papel))
            }
            if (randomStr == "Tesoura") {
                resultado = empate
                ivPadrao.setImageResource((R.drawable.tesoura))
            }
            tvTitle.setText("O CPU escolheu ${randomStr}")
            tvBody.setText("Você escolheu Pedra!! ${resultado}")
            ivPapel.setVisibility(View.GONE)
            ivPedra.setVisibility(View.GONE)
        }
    }
}