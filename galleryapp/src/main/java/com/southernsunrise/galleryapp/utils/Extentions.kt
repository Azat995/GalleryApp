package com.southernsunrise.galleryapp.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.openFragment(
    containerId: Int,
    fragment: Fragment,
    addToBackStack: Boolean = true
) {
    supportFragmentManager.beginTransaction().also {
        it.add(containerId, fragment)
        if (addToBackStack) it.addToBackStack(null)
        it.commit()
    }

}

fun Context.showToast(message: String) =
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
