package com.example.composedemo

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**********
 * Method to show toast message_to by passing message_to on it.
 */
fun Context.showToast(message: String) {
    Toast.makeText(this, message + "", Toast.LENGTH_SHORT).show()
}
/**********.
 * Method to hide keyboard.
 */
fun Context.hideKeyboard( view: View?) {
    if (view != null) {
        val inputManager =
            this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }
}

/**********
 * Method to check data connection availability (if network is available then it will return true otherwise false).
 */
fun Context.isInternetAvailable(): Boolean {
    try {
        val cm =
            this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        if (netInfo != null && netInfo.isConnectedOrConnecting && cm.activeNetworkInfo.isAvailable && cm.activeNetworkInfo.isConnected) {
            return true
        }
        return false
    } catch (err: Exception) {
        err.printStackTrace()
    }
    return false
}


fun View.makeVisible(){
    this.visibility=View.VISIBLE
}
fun View.makeGone(){
    this.visibility=View.GONE
}