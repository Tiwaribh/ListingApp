package com.example.composedemo

import android.R
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel
import java.util.regex.Pattern

/**
 * Created by Bhoopesh.
 */
object AppHelper {


    /**********
     * Method to print Log message_to by passing tag and message_to.
     */
    fun log(tag: String?, message: String?) {
        try {
            Log.d(tag, message)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    /**********
     * Method to show Dialog by passing Context, message_to and title which we want to show on it.
     */
    fun showDialog(
        context: Context?,
        message: String?,
        title: String?
    ) {
        val builder = AlertDialog.Builder(context)
        builder.setMessage(message)
            .setTitle(title).setCancelable(false)
            .setPositiveButton(R.string.ok, null)
        val dialog = builder.create()
        dialog.show()
    }


}