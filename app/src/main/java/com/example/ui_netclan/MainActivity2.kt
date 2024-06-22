package com.example.ui_netclan

import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_netclan.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(binding.root)


        val image = binding.image
        image.setOnClickListener { finish() }

        val editText = binding.editText
        val characterCountTextView = binding.characterCountTextView

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Not needed in this case
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Update the character count
                val currentLength = s?.length ?: 0
                characterCountTextView.text = "$currentLength/250"
            }

            override fun afterTextChanged(s: Editable?) {
                // Not needed in this case
            }
        })

        // Define the color for the progressing SeekBar
        val progressingColor = resources.getColor(R.color.Prussian_Blue)

        // Create a color filter with the progressing color
        val colorFilter = PorterDuffColorFilter(progressingColor, PorterDuff.Mode.SRC_IN)

        val seekBar = binding.seekBar
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Apply the color filter to the progress drawable
                seekBar?.progressDrawable?.colorFilter = colorFilter
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // No action needed
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Remove the color filter when the SeekBar stops progressing
                seekBar?.progressDrawable?.clearColorFilter()
            }
        })

        // Get references to the TextViews
        val options = arrayOf(
            binding.option1,
            binding.option2,
            binding.option3,
            binding.option4,
            binding.option5,
            binding.option6,
            binding.option7,
            binding.option8
        )

        // Set click listeners for the TextViews
        options.forEach { option ->
            setOptionClickListener(option)
        }

        val spinner = binding.spinner

        // Create an array of options
        val optionsArray = arrayOf(
            "Available| Hey let us connect",
            "Away| Stay Discreet And Watch",
            "Busy| Do Not Disturb | Will catch up later",
            "SOS| Emergency ! Need Assistance ! HELP"
        )

        // Create an ArrayAdapter using the options array and a default spinner layout
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, optionsArray)

        // Specify the layout to use when the list of options appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set the adapter for the Spinner
        spinner.adapter = adapter
    }

    private fun setOptionClickListener(option: TextView) {
        option.setOnClickListener {
            // Toggle the selection state
            val isSelected = option.isSelected
            option.isSelected = !isSelected

            // Change the background based on the selection state
            if (isSelected) {
                option.setBackgroundResource(R.drawable.unselected_box_background)
                option.setTextColor(resources.getColor(R.color.black))
            } else {
                option.setBackgroundResource(R.drawable.selected_box_background)
                option.setTextColor(resources.getColor(R.color.white))
            }
        }
    }
}
