package com.example.editor

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import com.example.editor.MainActivity.Companion.paintbrush
import com.example.editor.MainActivity.Companion.path
import com.example.editor.MainActivity.Companion.tool
import com.example.editor.MyCanvasView.Companion.colorList
import com.example.editor.MyCanvasView.Companion.currentBrush
import com.example.editor.MyCanvasView.Companion.pathList
import com.example.editor.R



class MyCanvasView: View {

    var params: ViewGroup.LayoutParams? = null

    companion object {
       // var path = Path()
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK


    }

    constructor(context: Context) : this(context, null) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }


    fun init() {
        paintbrush.apply {
            color = currentBrush
            // Smooths out edges of what is drawn without affecting shape.
            isAntiAlias = true
            // Dithering affects how colors with higher-precision than the device are down-sampled.

            style = Paint.Style.STROKE // default: FILL
            strokeJoin = Paint.Join.ROUND // default: MITER
            strokeCap = Paint.Cap.ROUND // default: BUTT
            strokeWidth =10f
           // strokeWidth = 12f // default: Hairline-width (really thin)
            params = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    //private var motionTouchEventX = 0f
  //  private var motionTouchEventY = 0f

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var motionTouchEventX = event.x
        var motionTouchEventY = event.y
        if (tool == 1) {
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    //    path.reset()
                    path.moveTo(motionTouchEventX, motionTouchEventY)

                    return true
                }
                MotionEvent.ACTION_MOVE -> {

                    path.lineTo(motionTouchEventX, motionTouchEventY)
                    pathList.add(path)
                    colorList.add(currentBrush)
                }

                else -> return false
            }
            postInvalidate()
            return false
        }
        if(tool==2){
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    //    path.reset()
                    path.moveTo(motionTouchEventX, motionTouchEventY)

                    return true
                }
                MotionEvent.ACTION_MOVE -> {

                    path.lineTo(motionTouchEventX, motionTouchEventY)
                    pathList.add(path)
                    colorList.add(currentBrush)
                }

                else -> return false
            }
            postInvalidate()
            return false
        }
        else
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                      path.reset()
                    path.moveTo(motionTouchEventX, motionTouchEventY)

                    return true
                }
                MotionEvent.ACTION_MOVE -> {

                    path.lineTo(motionTouchEventX, motionTouchEventY)
                    pathList.add(path)
                    colorList.add(currentBrush)
                }

                else -> return false
            }
        postInvalidate()
        return false
    }
    override fun onDraw(canvas: Canvas) {
        for(i in pathList.indices){
            paintbrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintbrush)
            invalidate()
        }
    }

}
