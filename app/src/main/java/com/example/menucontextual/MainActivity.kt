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

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.descargar -> {
                Toast.makeText(this, "Opción descargar", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.compartir -> {
                Toast.makeText(this, "Opción compartir", Toast.LENGTH_SHORT).show()
                true
            }

            R.id.copiar -> {
                Toast.makeText(this, "Opción copiar", Toast.LENGTH_SHORT).show()
                true
            }

            else -> {
                super.onContextItemSelected(item)
            }
        }
    }
}
