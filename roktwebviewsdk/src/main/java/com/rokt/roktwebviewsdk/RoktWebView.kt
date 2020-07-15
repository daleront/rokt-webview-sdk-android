/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsdk

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import java.lang.ref.WeakReference

/**
 * To use, replace instances of WebView with RoktWebView.
 * Calls to RoktWebViewSDK.open(url) will open in an external browser.
 */
@SuppressLint("SetJavaScriptEnabled")
class RoktWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {

    init {
        updateUserAgentString()
        enableJavascript()
        addJavascriptInterface()
    }

    /**
     * Updates user agent to have ` RoktWebViewSDK/[BuildConfig.VERSION_NAME]` at the end of
     * existing user agent.
     */
    private fun updateUserAgentString() {
        settings?.run {
            userAgentString = ("$userAgentString$roktUserAgentString")
        }
    }

    private fun enableJavascript() {
        settings?.run {
            javaScriptEnabled = true
        }
    }

    /**
     * Add Javascript interface for capturing RoktWebViewSDK.open(url)
     */
    private fun addJavascriptInterface() {
        RoktWebViewJsInterface(WeakReference(context), WeakReference(this)).apply {
            addJavascriptInterface(this, WEB_INTERFACE_NAME)
        }
    }
}