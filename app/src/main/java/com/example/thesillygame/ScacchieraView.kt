package com.example.thesillygame

import android.content.Context
import android.content.DialogInterface
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v7.app.AlertDialog
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.thesillygame.Scacchiera.scacchieraList
import com.example.thesillygame.ValueChanged.nmosse
import com.example.thesillygame.ValueChanged.nvittorie

var ndivisioni = 4

class ScacchieraView: View {
    constructor(context: Context):  super(context, null)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs, 0)

    var schermo = Rect()
    var paint = Paint()
    var dx : Int = 0

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.getClipBounds(schermo)
        drawScacchiera(canvas)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        scacchieraList.forEach {
            if (event!!.x > it.left && event.x < it.right && event.y < it.bottom && event.y > it.top)
            {
                if (it.colore == colore1)
                    it.colore = colore2
                else
                    it.colore = colore1

                var element = scacchieraList.find{ casella -> casella.i == it.i + 1 && casella.j == it.j}
                if (element?.colore == colore2)
                    element.colore = colore1
                else
                    element?.colore = colore2

                element = scacchieraList.find{ casella -> casella.i == it.i && casella.j == it.j+1}
                if (element?.colore == colore2)
                    element.colore = colore1
                else
                    element?.colore = colore2

                element = scacchieraList.find{ casella -> casella.i == it.i - 1 && casella.j == it.j}
                if (element?.colore == colore2)
                    element.colore = colore1
                else
                    element?.colore = colore2

                element = scacchieraList.find{ casella -> casella.i == it.i && casella.j == it.j - 1}
                if (element?.colore == colore2)
                    element.colore = colore1
                else
                    element?.colore = colore2
                nmosse = nmosse + 1

                if (controllaVittoria()) {
                    nvittorie = nvittorie + 1
                    creaAlert()
                }
                invalidate()
            }
        }

        return super.onTouchEvent(event)
    }

    fun controllaVittoria():Boolean {
        var primoColore = scacchieraList.first().colore
        scacchieraList.forEach {
            if (it.colore != primoColore){
                return false
            }
        }
        return true
    }


    fun drawScacchiera(canvas: Canvas?) {
        dx = (schermo.right - schermo.left) / ndivisioni
        scacchieraList.forEach {
            var casella = Rect(dx * (it.j - 1), dx * (it.i - 1), (dx * (it.j)) - 1, (dx * it.i) - 1)
            //salvo le coordinate di ogni casella
            it.top = dx * (it.i - 1)
            it.bottom = (dx * it.i) - 1
            it.left = dx * (it.j - 1)
            it.right = (dx * (it.j)) - 1

            paint.color = it.colore
            canvas?.drawRect(casella, paint)
        }
    }

    fun creaAlert(){
            AlertDialog.Builder(this.context)
            .setCancelable(false)
            .setTitle("Hai vinto!")
            .setMessage("Complimenti!!!")
            .setNeutralButton("Ok", DialogInterface.OnClickListener { dialog, which -> })
            .create().show()
    }

}
