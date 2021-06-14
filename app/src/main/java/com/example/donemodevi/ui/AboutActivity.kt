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
    lateinit var metin: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "HAKKINDA"

        foto=findViewById(R.id.foto)
        adsoyad=findViewById(R.id.adsoyad)
        numara=findViewById(R.id.numara)
        metin=findViewById(R.id.metin)

        foto.setBackgroundResource(R.mipmap.ppp)
        adsoyad.setText("AD SOYAD: SERKAN KONUKCU")
        numara.setText("ÖĞRENCİ NUMARASI: 191030025")
        metin.setText("C# dili üzerinde çeşitli projeler yapmaktayım. PHP'de kendimi geliştiriyorum. PHP'ye yönelebilirim. Aslında şu dönem için meslek hayatımda ne yapmak istediğim konusu biraz karışık " +
        "Eskiden sabit olan fikirlerimi biraz daha değiştirdim ve genişlettim, çünkü hayatta her şey olabiliyormuş.")
    }
}