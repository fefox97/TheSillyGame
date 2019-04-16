package com.example.thesillygame

import android.graphics.Color
import com.example.thesillygame.ValueChanged.nmosse

var colore1 = Color.RED
var colore2 = Color.BLUE

object Scacchiera {
    var scacchieraList = mutableListOf<Casella>()

    init {
        inizializza()
    }

    fun inizializza(){
        scacchieraList.removeAll(scacchieraList)
        for (k in 1..ndivisioni) {
            for (q in 1..ndivisioni) {
                var colore = 0
                if ((0..1).random() == 0)
                    colore = colore1
                else
                    colore = colore2
                scacchieraList.add(Casella(k,q,colore,0,0,0,0))
            }
        }
        nmosse = 0
    }
}