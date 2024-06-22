package com.example.ui_netclan

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.view.WindowManager
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.ui_netclan.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fabMenu: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = null

        val navigationIcon = binding.image
        val refineIcon = binding.image2
        val nav1 = binding.button1
        val nav2 = binding.button2
        val nav3 = binding.button3
        val filter = binding.button4
        val txt = binding.textView

        navigationIcon.setOnClickListener {
            Toast.makeText(this@MainActivity, "Navigation icon  has been clicked", Toast.LENGTH_SHORT).show()
        }

        val locationIcon: Drawable? = ContextCompat.getDrawable(this, R.drawable.ic_loc_icon)
        txt.text = "Howdy Username!!"
        val existingText = txt.text.toString()
        locationIcon?.let {
            txt.setCompoundDrawablesWithIntrinsicBounds(it, null, null, null)
        }
        val newText = "$existingText\nLocation"
        txt.text = newText

        refineIcon.setOnClickListener {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
        }

        nav1.setOnClickListener {
            Toast.makeText(this@MainActivity, "Navigation icon 1 has been clicked", Toast.LENGTH_SHORT).show()
        }
        nav2.setOnClickListener {
            Toast.makeText(this@MainActivity, "Navigation icon 2 has been clicked", Toast.LENGTH_SHORT).show()
        }
        nav3.setOnClickListener {
            Toast.makeText(this@MainActivity, "Navigation icon 3 has been  clicked", Toast.LENGTH_SHORT).show()
        }
        filter.setOnClickListener {
            Toast.makeText(this@MainActivity, "Filter button has been clicked", Toast.LENGTH_SHORT).show()
        }

        fabMenu = binding.fabMenu

        fabMenu.setOnClickListener {
            showPopupMenu()
        }
    }

    private fun showPopupMenu() {
        val popupMenu = PopupMenu(this, fabMenu)
        popupMenu.inflate(R.menu.menu_options) // Your menu resource file

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_item1 -> {
                    // Handle option 1 selection
                    true
                }
                R.id.menu_item2 -> {
                    // Handle option 2 selection
                    true
                }
                R.id.menu_item3 -> {
                    // Handle option 3 selection
                    true
                }
                // Add more cases for each option in your menu
                else -> false
            }
        }

        popupMenu.show()
    }
}
