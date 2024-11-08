package com.example.instagram.common

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.instagram.R

class CustomDialog(context: Context) : Dialog(context) {

    private lateinit var dialogLinearLayout : LinearLayout
    private lateinit var textButtons : Array<TextView>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLinearLayout = findViewById(R.id.container_dialog)
    }

    fun addButton(listener: View.OnClickListener, vararg texts: Int) {
        textButtons = Array(texts.size) {
            TextView(context)
        }

        texts.forEachIndexed { index, txtId ->
            textButtons[index].setText(txtId)
            textButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()

        for(textView in textButtons) {
            dialogLinearLayout.addView(textView)
        }
    }
}