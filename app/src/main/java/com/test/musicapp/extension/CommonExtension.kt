package com.test.musicapp.extension

import android.app.Activity
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


internal fun Activity.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
        show()
    }
}

internal fun Fragment.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_LONG).apply {
        show()
    }
}


fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

