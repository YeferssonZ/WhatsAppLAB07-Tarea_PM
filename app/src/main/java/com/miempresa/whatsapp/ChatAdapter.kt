package com.miempresa.whatsapp

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class ChatAdapter(private val chats: List<Chat>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_whatsapp, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chats[position]
        holder.bind(chat)
    }

    override fun getItemCount(): Int = chats.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imagenPerfil: ImageView = itemView.findViewById(R.id.imagen_perfil)
        private val nombreContacto: TextView = itemView.findViewById(R.id.nombre_contacto)
        private val ultimoMensaje: TextView = itemView.findViewById(R.id.ultimo_mensaje)
        private val tiempoEnvio: TextView = itemView.findViewById(R.id.tiempo_envio)
        private val numMensajes: TextView = itemView.findViewById(R.id.num_mensajes)

        fun bind(chat: Chat) {
            imagenPerfil.setImageResource(chat.imagenPerfil)
            nombreContacto.text = chat.nombreContacto
            ultimoMensaje.text = chat.ultimoMensaje
            tiempoEnvio.text = chat.tiempoEnvio
            numMensajes.text = chat.numMensajes?.toString() ?: ""
            if (chat.numMensajes != null) {
                tiempoEnvio.setTextColor(ContextCompat.getColor(itemView.context, R.color.holo_green))
                tiempoEnvio.setTypeface(null, Typeface.BOLD)
                tiempoEnvio.text = chat.tiempoEnvio
                numMensajes.text = chat.numMensajes.toString()
                numMensajes.visibility = View.VISIBLE
            } else {
                tiempoEnvio.setTextColor(ContextCompat.getColor(itemView.context, android.R.color.black))
                tiempoEnvio.setTypeface(null, Typeface.NORMAL)
                tiempoEnvio.text = if (chat.tiempoEnvio.isNotEmpty()) chat.tiempoEnvio else ""
                numMensajes.visibility = View.GONE
            }
        }
    }
}
