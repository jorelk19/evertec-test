package com.evertec.edson.ui.utils

import android.content.Context.WIFI_SERVICE
import android.net.wifi.WifiManager
import android.text.format.Formatter
import com.evertec.di.app.App
import java.util.*


object NetworkUtil {
    fun getIpAddress() : String{
        val wm = App.getAppContext().applicationContext.getSystemService(WIFI_SERVICE) as WifiManager?
        val ip: String = Formatter.formatIpAddress(wm!!.connectionInfo.ipAddress)
        return ip
    }
}