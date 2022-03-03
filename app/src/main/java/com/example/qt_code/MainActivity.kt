package com.example.qt_code

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
                textView.text = "Test"
        }
        // Тест парсинга
        val textViewParsig: TextView = findViewById(R.id.textView3)
        val buttonParsig: Button = findViewById(R.id.button2)

        buttonParsig.setOnClickListener {
            val html = ("<html><head><title>Коты учатся кодить</title>"
                    + "<body><p>Коты умеют <del>ш</del>кодить.<br> Они великие программисты." +
                    "<p>А еще они умеют мяукать.</p>" +
                    "<a href='http://developer.alexanderklimov.ru'>Подробности здесь</a>" +
                    "</body></html>")
            //try{
                val doc = Jsoup.connect("https://yandex.ru/").get()
                //val title = doc.title()
                //textViewParsig.setText(title)
            //} catch (e: Exception){
            //    e.printStackTrace()
           // }

            /*
            //val doc = Jsoup.parse(html) // Здась может быть адрес страницы
            //textViewParsig.text = doc.html() // чтение всего документа
            textViewParsig.text = doc.title()  // Извлечение заголовка
            */
            // получение ссылки
            val link = doc.select("a").first()
            val linkHref = link.attr("href")
            textViewParsig.text = linkHref
            // получение текта ссылки
            val linkInnerH = link.html()
            textViewParsig.text = linkInnerH

        }
    }
}