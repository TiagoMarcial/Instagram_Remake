package dev.tiagomarcial.instagram.login.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import dev.tiagomarcial.instagram.R

class LoadingButton: FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setup(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setup(context, attrs)
    }

    private fun setup(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.button_loading, this)
    }
}