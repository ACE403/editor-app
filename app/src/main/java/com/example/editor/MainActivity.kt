package com.example.editor

import android.content.Intent

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils

import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.ImageButton

import androidx.core.content.res.ResourcesCompat

import com.example.editor.MyCanvasView.Companion.currentBrush

import com.example.editor.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
    companion object {

        var path=Path()
        var paintbrush = Paint()
        var tool=0
    }


//        val adapter = ArrayAdapter(
//            this, android.R.layout.simple_spinner_dropdown_item, arrayListOf("all types","assignment","exam")
//        )
//        binding.autoCompleteTextView.setAdapter(adapter)
////        binding.autoCompleteTextView.setText("All Types")
//        binding.autoCompleteTextView.setDropDownBackgroundDrawable(
//            ResourcesCompat.getDrawable(
//                resources,
//                R.drawable.filter_spinner_dropdown_bg,
//                null
//            )
//        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

         val pen = findViewById<ImageButton>(R.id.pen)
         val eraser=findViewById<ImageButton>(R.id.eraser)
        val red=findViewById<ImageButton>(R.id.red_color)
        val green=findViewById<ImageButton>(R.id.green_color)
        val blue=findViewById<ImageButton>(R.id.blue_color)
        val yellow=findViewById<ImageButton>(R.id.yellow_color)
        val goto=findViewById<ImageButton>(R.id.link)

        val mycolors= listOf("india","china","usa")
//        val feelings=resources.getStringArray(R.array.feelings)
        val adapter = ArrayAdapter(this,R.layout.dropdown_item,mycolors)
        binding.autoCompleteTextView.setAdapter(adapter)

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
    fun AutoCompleteTextView.showDropdown(adapter: ArrayAdapter<String>?) {
        if(!TextUtils.isEmpty(this.text.toString())){
            adapter?.filter?.filter(null)
        }
    }


}