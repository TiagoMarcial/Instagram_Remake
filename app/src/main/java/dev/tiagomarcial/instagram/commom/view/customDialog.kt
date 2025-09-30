package dev.tiagomarcial.instagram.commom.view

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import dev.tiagomarcial.instagram.R

class customDialog(context : Context) : Dialog(context) {

    private lateinit var dialogLinearLayout: LinearLayout
    private lateinit var txtButtons: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLinearLayout = findViewById(R.id.dialog_container)
    }

    fun addButton(listener: View.OnClickListener, vararg texts: Int) {
        txtButtons = Array(texts.size) { TextView(context) }

        texts.forEachIndexed { index, txtId ->
            txtButtons[index].setText(txtId)
            txtButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()
        for (textView in txtButtons) {dialogLinearLayout.addView(textView)}
    }
}