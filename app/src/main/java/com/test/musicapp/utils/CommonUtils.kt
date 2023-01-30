package com.test.musicapp.utils

import android.util.Base64


fun String.encodeText(): String {
    return Base64.encodeToString(this.toByteArray(), Base64.DEFAULT)
}
