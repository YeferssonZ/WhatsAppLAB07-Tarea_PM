package com.miempresa.whatsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chats = obtenerChats()

        recyclerView = findViewById(R.id.lista)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = ChatAdapter(chats)
        recyclerView.adapter = adapter
    }

    private fun obtenerChats(): List<Chat> {
        return listOf(
            Chat(R.drawable.image02, "+ 51 973 610 591", "You: Hola, cómo andas de salud?", "22:31 PM"),
            Chat(R.drawable.image04, "Alfredo Tec", "Me apellido MessCO", "9:48 AM", 2),
            Chat(R.drawable.image03, "Brandon", "Voy a llegar un poco tarde mano", "8:45 AM", 8),
            Chat(R.drawable.image01, "Jade C.", "En donde andas ahora", "Yesterday", 3),
            Chat(R.drawable.image05, "+ 51 953 767 550", "You: Que hay de nuevo mano", "Yesterday"),
            Chat(R.drawable.image07, "Freddy Tec", "Que tal el trabajo de Programación?", "Tuesday", 1),
            Chat(R.drawable.image06, "Mayra", "Cuando vamos a la reunión del grupo...", "Tuesday", 2),
            Chat(R.drawable.image09, "Mary", "Vas ir mañana a la conferencia?", "Monday", 4),
            Chat(R.drawable.image08, "Thania Z.", "No me sale ese apartado del dibujo", "28/04/23"),
            Chat(R.drawable.image10, "Rayo", "You: Viste el último capítulo de Shingeki?", "20/04/23")
        )
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var selectOpcion = ""

        when (item?.itemId){
            R.id.ajustes -> selectOpcion = "Ajustes"
            R.id.acerca -> selectOpcion = "Acerca de..."
            R.id.mensajes -> selectOpcion = "Notificaciones"
            R.id.buscar -> selectOpcion = "Buscar"
        }

        Toast.makeText(this, "Opción: "+ selectOpcion, Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }

}