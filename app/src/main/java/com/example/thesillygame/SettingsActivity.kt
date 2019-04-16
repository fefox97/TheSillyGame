package com.example.thesillygame

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.flask.colorpicker.ColorPickerView
import com.flask.colorpicker.builder.ColorPickerDialogBuilder
import kotlinx.android.synthetic.main.activity_settings.*


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        color1.setOnClickListener{
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
            Scacchiera.inizializza()
        }
        color2.setOnClickListener {
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
            Scacchiera.inizializza()
        }
    }
}


