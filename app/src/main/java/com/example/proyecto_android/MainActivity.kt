package com.example.proyecto_android


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        miRecycler = findViewById(R.id.RecyclerPersonajes)
        listaJ = ArrayList<Juego>()
        adapter = AdaptadorJuegos(listaJ)
        miRecycler.adapter = adapter
        getData()
        miRecycler.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
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
                val juego = Juego(juegosIndJson.getString("title"),juegosIndJson.getString("thumb"),juegosIndJson.getString("salePrice"))
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

