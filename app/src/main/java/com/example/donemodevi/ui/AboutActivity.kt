package com.example.donemodevi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.donemodevi.R

class AboutActivity : AppCompatActivity() {
    lateinit var foto: ImageView
    lateinit var adsoyad: TextView
    lateinit var numara: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "HAKKINDA"

        foto=findViewById(R.id.foto)
        adsoyad=findViewById(R.id.adsoyad)
        numara=findViewById(R.id.numara)

        foto.setBackgroundResource(R.mipmap.ppp)
        adsoyad.setText("AD SOYAD: SERKAN KONUKCU")
        numara.setText("ÖĞRENCİ NUMARASI: 191030025")
    }
}