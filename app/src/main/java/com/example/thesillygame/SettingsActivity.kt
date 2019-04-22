package com.example.thesillygame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.thesillygame.ValueChanged.colore1
import com.example.thesillygame.ValueChanged.colore2
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Fa parte del listener su mosse
        ValueChanged.refreshListListeners.add(::refreshColore1)
        ValueChanged.refreshListListeners.add (::refreshColore2)

        color1_btn.setOnClickListener{
            ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(0xffffffff.toInt())
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setOnColorSelectedListener { }
                .setPositiveButton("Ok") { dialog, selectedColor, allColors -> colore1 = selectedColor }
                .setNegativeButton("cancel") { dialog, which -> }
                .build()
                .show()
        }
        color2_btn.setOnClickListener {
            ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(0xffffffff.toInt())
                .wheelType(ColorPickerView.WHEEL_TYPE.CIRCLE)
                .density(12)
                .setOnColorSelectedListener { }
                .setPositiveButton("ok") { dialog, selectedColor, allColors -> colore2 = selectedColor }
                .setNegativeButton("cancel") { dialog, which -> }
                .build()
                .show()
        }
    }

    // Fa parte del listener su mosse
    //TODO: aggiungere refresh automatico della scacchiera al cambio colore
    fun refreshColore1(){
        color1_btn.setBackgroundColor(colore1)
    }

    fun refreshColore2(){
        color2_btn.setBackgroundColor(colore2)
    }
}


