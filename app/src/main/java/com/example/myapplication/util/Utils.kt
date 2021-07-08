package com.example.myapplication.util

import android.content.Context
import android.view.LayoutInflater
import android.widget.TextView
import com.example.myapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

object Utils {
    fun showDialog(context: Context, message: String?, action: (() -> Unit)? = null) {
        val dialogBuilder = MaterialAlertDialogBuilder(context)
        val v =
            LayoutInflater.from(context).inflate(R.layout.alert_dialog, null, false)
        dialogBuilder.setView(v)
            .setCancelable(false)
            .setOnDismissListener {
                action?.invoke()
            }
        val alertDialog = dialogBuilder.create()
        v.findViewById<TextView>(R.id.message).setText(message ?: "")
        v.findViewById<TextView>(R.id.btnAction).setOnClickListener { alertDialog.dismiss() }
        alertDialog.show()
    }
}