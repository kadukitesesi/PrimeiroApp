package com.kadukitesesi.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.Instant
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val titulo: TextView = findViewById(R.id.textView)
        val login: Button = findViewById(R.id.login)

        fun buscarInstante(): String {

            val instante: Instant = Instant.now()
            val dateFormater: DateTimeFormatter = DateTimeFormatter.ofPattern("mm:ss")
            val zoned: ZonedDateTime = instante.atZone(ZoneId.systemDefault())
            val instanteFormatado: String = zoned.format(dateFormater)

            return instanteFormatado
        }

        login.setOnClickListener {
            titulo.setTextColor(getColor(R.color.verdin))
            val busca: String = buscarInstante()
            titulo.text = "Momento formatado: $busca"
            titulo.textSize = 20f
        }
    }
}