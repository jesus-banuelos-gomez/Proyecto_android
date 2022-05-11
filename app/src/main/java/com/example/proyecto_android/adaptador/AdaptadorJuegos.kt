package com.example.proyecto_android.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proyecto_android.R
import com.example.proyecto_android.modelo.juegos
import com.squareup.picasso.Picasso

class AdaptadorJuegos(val listaJuegos:ArrayList<juegos>):RecyclerView.Adapter<AdaptadorJuegos.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.vista_indi,parent,false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.tvNombre.text = listaJuegos[position].nombre
        Picasso.get().load(listaJuegos[position].foto).into(holder.ivFoto)
    }

    override fun getItemCount(): Int {
        return listaJuegos.size
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