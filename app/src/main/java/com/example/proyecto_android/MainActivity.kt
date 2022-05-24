package com.example.proyecto_android


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.proyecto_android.adaptador.AdaptadorJuegos
import com.example.proyecto_android.modelo.Juego

class MainActivity : AppCompatActivity() {
    lateinit var miRecycler:RecyclerView
    lateinit var listaJ:ArrayList<Juego>
    lateinit var adapter:AdaptadorJuegos
    lateinit var  btnCreditos:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCreditos = findViewById(R.id.btnCreditos)
        miRecycler = findViewById(R.id.RecyclerPersonajes)
        listaJ = ArrayList<Juego>()
        adapter = AdaptadorJuegos(listaJ)
        miRecycler.adapter = adapter
        getData()
        miRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        btnCreditos.setOnClickListener{
                val intelCreditos = Intent(this,creditosActivity::class.java)
                startActivity(intelCreditos)
        }
    }
fun getData(){
    val queue = Volley.newRequestQueue(this)
    val url = "https://www.cheapshark.com/api/1.0/deals?storeID=1&upperPrice=15"



    val objectRequest = JsonArrayRequest(
        Request.Method.GET,
        url,
        null,
        { response ->


            for(indice in 0..response.length()-1){
                val juegosIndJson = response.getJSONObject(indice)
                val juego = Juego(juegosIndJson.getString("title"),
                                  juegosIndJson.getString("normalPrice"),
                                  juegosIndJson.getString("dealRating"),
                                  juegosIndJson.getString("thumb"))
                listaJ.add(juego)
            }
            adapter.notifyDataSetChanged()
        },

        {
            Log.e("PersonajesAPI","Error")
        }

    )
    queue.add(objectRequest)
}


}

