package ru.startandroid.develop.touch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.TextView

class MainActivity : AppCompatActivity(), OnTouchListener {

    private lateinit var tv: TextView
    private var x: Float = 0f
    private var y: Float = 0f
    private var sDown: String? = null
    private var sMove: String? = null
    private var sUp: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tv = TextView(this)
        tv.setOnTouchListener(this)
        setContentView(tv)
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        x = event!!.x
        y = event.y

        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                sDown = "Down: $x , $y"
                sMove = ""
                sUp = ""
            }
            MotionEvent.ACTION_MOVE -> sMove = "Move: $x , $y"

            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                sMove = ""
                sUp = "Up: $x,$y"
            }
        }
        tv.text = """
            $sDown 
            $sMove 
            $sUp
            """.trimMargin()
        return true
    }
}