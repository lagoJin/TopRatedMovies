package com.lago.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.ActionMode
import androidx.appcompat.widget.AppCompatEditText

class NumberEditText @JvmOverloads constructor(
    context: Context, attributeSet: AttributeSet? = null, defStyleAtr: Int = 0
) : AppCompatEditText(
    context, attributeSet, defStyleAtr
) {

    private var space: Float = 24.0f
    private var numChars: Float = 4.0f
    private var lineSpacing: Float = 8.0f
    private var maxLength: Int = 4
    private var lineStroke: Float = 2.0f
    private var linesPaint: Paint
    private lateinit var clickListener: OnClickListener

    init {
        val multi = context.resources.displayMetrics.density
        lineStroke *= multi
        linesPaint = Paint(paint)
        linesPaint.strokeWidth = lineStroke
        linesPaint.color = resources.getColor(R.color.colorPrimaryDark)
        setBackgroundResource(0)
        space *= multi
        lineSpacing *= multi
        numChars = maxLength.toFloat()

        super.setOnClickListener { view ->
            setSelection(text!!.length)
            if (::clickListener.isInitialized) {
                clickListener.onClick(view)
            }
        }
    }

    override fun setOnClickListener(onClickListener: OnClickListener?) {
        onClickListener?.let {
            clickListener = onClickListener
        }
    }

    override fun setCustomSelectionActionModeCallback(actionModeCallback: ActionMode.Callback?) {
        throw RuntimeException("setCustomSelectionActionModeCallback() not supported")
    }

    override fun onDraw(canvas: Canvas?) {
        val availableWidth = width - paddingRight - paddingLeft
        var charSize = 0f

        charSize = if (space < 0) {
            (availableWidth / (numChars * 2 - 1))
        } else {
            (availableWidth - (space * (numChars - 1))) / numChars
        }

        var startX = paddingLeft
        val bottom = height - paddingBottom

        val text = text!!
        val textLength = text.length
        val textWidths = FloatArray(textLength)
        paint.getTextWidths(text, 0, textLength, textWidths)

        for (i in 0..numChars.toInt()) {
            canvas?.drawLine(
                startX.toFloat(),
                bottom.toFloat(),
                startX + charSize,
                bottom.toFloat(),
                linesPaint
            )
            if (text.length > i) {
                val middle = startX + charSize / 2
                canvas?.drawText(
                    text,
                    i,
                    i + 1,
                    middle - textWidths[0] / 2,
                    bottom - lineSpacing,
                    paint
                )
            }
            startX += if (space < 0) {
                charSize.toInt() * 2
            } else {
                charSize.toInt() + space.toInt()
            }
        }

    }
}
