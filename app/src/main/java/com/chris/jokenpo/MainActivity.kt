package com.chris.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val ivPadrao by lazy { findViewById<ImageView>(R.id.ivPadrao) }
    private val ivPedra by lazy { findViewById<ImageView>(R.id.ivPedra) }
    private val ivPapel by lazy { findViewById<ImageView>(R.id.ivPapel) }
    private val ivTesoura by lazy { findViewById<ImageView>(R.id.ivTesoura) }
    private val tvTitle by lazy { findViewById<TextView>(R.id.tvTitle) }
    private val tvBody by lazy { findViewById<TextView>(R.id.tvBody) }
    private var userChoose : Int? = null
    private var cpuChoose : Int? = null
    private var userChooseStr : String? = null
    private var cpuChooseStr : String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()

    }

    private fun setListeners() {
        ivPedra.setOnClickListener{
            userChooseStr = getString(R.string.stone)
            userChoose = STONE
            cpuChoose()
            result()
            ivPapel.setVisibility(View.GONE)
            ivTesoura.setVisibility(View.GONE)
        }

        ivPapel.setOnClickListener{
            userChooseStr = getString(R.string.stone)
            userChoose = PAPER
            cpuChoose()
            result()
            ivPedra.setVisibility(View.GONE)
            ivTesoura.setVisibility(View.GONE)
        }

        ivTesoura.setOnClickListener{
            userChooseStr = getString(R.string.scissor)
            userChoose = SCISSOR
            cpuChoose()
            result()
            ivPapel.setVisibility(View.GONE)
            ivPedra.setVisibility(View.GONE)
        }
    }

    private fun generateRandomNumber() = Random.nextInt(3)

    private fun cpuChoose() {
        when (generateRandomNumber()) {
            STONE -> {cpuChoose=STONE; cpuChooseStr=getString(R.string.stone); ivPadrao.setImageResource((R.drawable.pedra))}
            PAPER -> {cpuChoose=PAPER; cpuChooseStr=getString(R.string.paper); ivPadrao.setImageResource((R.drawable.papel))}
            SCISSOR -> {cpuChoose=SCISSOR; cpuChooseStr=getString(R.string.scissor); ivPadrao.setImageResource((R.drawable.tesoura))}
        }
        tvTitle.setText(getString(R.string.cpu_choose,cpuChooseStr))
    }

    private fun result() {
        when{
            userChoose == STONE && cpuChoose == STONE -> tvBody.setText(R.string.draw)
            userChoose == STONE && cpuChoose == PAPER -> tvBody.setText(R.string.lose)
            userChoose == STONE && cpuChoose == SCISSOR -> tvBody.setText(R.string.win)
            userChoose == PAPER && cpuChoose == STONE -> tvBody.setText(R.string.win)
            userChoose == PAPER && cpuChoose == PAPER -> tvBody.setText(R.string.draw)
            userChoose == PAPER && cpuChoose == SCISSOR -> tvBody.setText(R.string.lose)
            userChoose == SCISSOR && cpuChoose == STONE -> tvBody.setText(R.string.lose)
            userChoose == SCISSOR && cpuChoose == PAPER -> tvBody.setText(R.string.win)
            userChoose == SCISSOR && cpuChoose == SCISSOR -> tvBody.setText(R.string.draw)
        }
    }

    companion object {
        const val STONE = 0
        const val PAPER = 1
        const val SCISSOR = 2
    }

}