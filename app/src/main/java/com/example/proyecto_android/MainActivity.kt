package com.example.proyecto_android

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.textclassifier.TextSelection
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

fun getJuegos(){

    val queue = Volley.newRequestQueue(this)
    val url = "https://rickandmortyapi.com/api/character"

    val objectRequest = JsonObjectRequest(
        Request.Method.GET,
        url,
        null,
        Response.Listener { response ->
            val juegoJson = response.getJSONObject(indice)
        },

        Response.ErrorListener {
            
        }

    )

}