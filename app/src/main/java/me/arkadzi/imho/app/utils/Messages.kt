package me.arkadzi.imho.app.utils

import android.content.Context
import android.support.annotation.StringRes
import me.arkadzi.imho.R

import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


class Messages constructor(private val c: Context) {

    fun getError(e: Throwable): String {
        return if (e is SocketTimeoutException
                || e is ConnectException
                || e is UnknownHostException) {
            c.getString(R.string.err_network_connection)
        } else e.toString()
    }

}
