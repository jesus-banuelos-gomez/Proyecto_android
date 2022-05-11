package com.example.proyecto_android.adaptador

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_android.R
import com.example.proyecto_android.modelo.juegos

class adaptadorJuegos(val listaJuegos:ArrayList<juegos>):RecyclerView.Adapter<adaptadorJuegos.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
    val tvNombre: TextView
    val ivFoto: ImageView

    init {
        tvNombre = vista.findViewById(R.id.nombre_de_juego)
        ivFoto = vista.findViewById(R.id.imagen_juego)
    }
    }

}