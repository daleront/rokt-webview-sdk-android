/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package rokt.com.roktwebviewsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sampleHtmlString =
        "<html><button onclick=\"RoktWebViewSDK.open('')\">" +
                "Open Link</button></html>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("RoktWebView", "UserAgentString = " + webView.settings.userAgentString)

        webView.loadData(
            sampleHtmlString,
            "text/html",
            "UTF-8"
        )
    }
}
