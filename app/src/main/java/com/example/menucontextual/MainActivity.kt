package com.example.menucontextual

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.menucontextual.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imagen = binding.imagenUsuario
        registerForContextMenu(imagen)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.menu_contextual, menu)
        menu?.setHeaderTitle("Menú contextual")
    }

    //muestra toasts dependiendo de la opción seleccionada
    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.descargar -> {
                Toast.makeText(this, "Se va a descargar la imagen", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.compartir -> {
                Toast.makeText(this, "Se va a compartir la imagen", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.copiar -> {
                Toast.makeText(this, "Se ha copiado la imagen", Toast.LENGTH_SHORT).show()
                true
            }

            //no llegará a usarse, pero si la comento me da error
            else -> {
                super.onContextItemSelected(item)
            }
        }
    }
}
