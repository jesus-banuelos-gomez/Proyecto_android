package com.example.proyecto_android

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.textclassifier.TextSelection
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto_android.adaptador.AdaptadorJuegos
import com.example.proyecto_android.modelo.juegos

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






        val queue = Volley.newRequestQueue(this)
        val url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15"
        val listaJ = arrayListOf<juegos>()


        val objectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->

                val juegoJson = response.getJSONArray(null)
                for(indice in 0..juegoJson.length()-1){
                    val juegosIndJson = juegoJson.getJSONObject(indice)
                    val juegos = juegos(juegosIndJson.getString("internalName"),juegosIndJson.getString("title"))
                    listaJ.add(juegos)
                }

            },

            Response.ErrorListener {
                Log.e("PersonajesAPI","Error")
            }

        )
        queue.add(objectRequest)
        miRecycler = findViewById(R.id.RecyclerPersonajes)

        miRecycler.adapter = AdaptadorJuegos(listaJ)
        miRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }



}

