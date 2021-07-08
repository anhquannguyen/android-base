package com.example.myapplication.util

import android.Manifest
import android.view.ViewGroup
import android.widget.LinearLayout

object Constants {
    const val matchParent = ViewGroup.LayoutParams.MATCH_PARENT
    const val wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT
    const val vertical = LinearLayout.VERTICAL
    const val horizontal = LinearLayout.HORIZONTAL
    const val stateChecked = android.R.attr.state_checked
    const val stateEnabled = android.R.attr.state_enabled
    const val stateSelected = android.R.attr.state_selected
    const val stateFocused = android.R.attr.state_focused
    const val statePressed = android.R.attr.state_pressed

    const val CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE"

    const val Manifest_READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE
    const val Manifest_WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE
    const val Manifest_ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
    const val Manifest_RECORD_AUDIO = Manifest.permission.RECORD_AUDIO
    const val Manifest_READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE
    const val Manifest_CALL_PHONE = Manifest.permission.CALL_PHONE
    const val Manifest_CAMERA = Manifest.permission.CAMERA
}