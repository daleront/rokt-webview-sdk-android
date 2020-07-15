/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsdk

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.JavascriptInterface
import java.lang.ref.WeakReference

const val TAG = "RoktWebViewJsInterface"

/**
 *  JSInterface that supports opening links in an external browser.
 *  If a supported external browser doesn't exist on the device, the url
 *  is loaded in the WebView.
 */
class RoktWebViewJsInterface(
    private val contextWeak: WeakReference<Context>,
    private val roktWebViewWeak: WeakReference<RoktWebView>
) {
    @JavascriptInterface
    fun open(url: String) {
        contextWeak.get()?.let { context ->
            if (url.isEmpty()) {
                Log.e(TAG, "open() was called but url is empty.")
                return
            }

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            if (intent.canOpenInExternalApp(context)) {
                context.startActivity(intent)
            } else {
                Log.w(TAG, "No supported browsers installed on this device.")

                roktWebViewWeak.get()?.let { roktWebView ->
                    roktWebView.post { roktWebView.loadUrl(url) }
                }
            }
        }
    }
}

private fun Intent.canOpenInExternalApp(context: Context): Boolean {
    return resolveActivity(context.packageManager) != null
}