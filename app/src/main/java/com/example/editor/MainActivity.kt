package com.example.editor

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_FULLSCREEN
import android.widget.ImageButton
import com.example.editor.MyCanvasView
import com.example.editor.MyCanvasView.Companion.colorList
import com.example.editor.MyCanvasView.Companion.currentBrush
import com.example.editor.MyCanvasView.Companion.pathList

import com.example.editor.R



class MainActivity : AppCompatActivity() {
    companion object {

        var path=Path()
        var paintbrush = Paint()
        var tool=0
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

         val pen = findViewById<ImageButton>(R.id.pen)
         val eraser=findViewById<ImageButton>(R.id.eraser)
        val red=findViewById<ImageButton>(R.id.red_color)
        val green=findViewById<ImageButton>(R.id.green_color)
        val blue=findViewById<ImageButton>(R.id.blue_color)
        val yellow=findViewById<ImageButton>(R.id.yellow_color)
        val goto=findViewById<ImageButton>(R.id.link)

        goto.setOnClickListener{
            var browserIntent =  Intent(Intent.ACTION_VIEW, Uri.parse("http://localhost:8080/"))
            startActivity(browserIntent);

        }
         pen.setOnClickListener{

             tool=1
             paintbrush.setColor(Color.BLACK)
             currentColor(paintbrush.color)
        }
        eraser.setOnClickListener{

            tool=2
            paintbrush.setColor(Color.WHITE)
         //    pathList.clear()
         //   colorList.clear()
         //   path.reset()
            currentColor(paintbrush.color)
        }

        red.setOnClickListener{


            tool=3
            paintbrush.setColor(Color.RED)
            currentColor(paintbrush.color)
        }
        green.setOnClickListener{

            tool=1
            paintbrush.setColor(Color.GREEN)
            currentColor(paintbrush.color)
        }
        blue.setOnClickListener{

            tool=1
            paintbrush.setColor(Color.BLUE)
            currentColor(paintbrush.color)
        }
        yellow.setOnClickListener{

            tool=1
            paintbrush.setColor(Color.YELLOW)
            currentColor(paintbrush.color)

        }


    }

    private fun currentColor(color: Int) {
        currentBrush=color
        path= Path()
    }


}