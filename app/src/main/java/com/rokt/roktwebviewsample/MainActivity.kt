/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsample

import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val sampleHtmlString =
        "<html><button onclick=\"RoktWebViewSDK.open('https://rokt.com')\">" +
                "Open Link in External Browser</button></html>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonGo.setOnClickListener {
            editTextUrl.text.toString().let { urlString ->
                if (URLUtil.isValidUrl(urlString)) {
                    webView.loadUrl(urlString)
                } else {
                    Toast.makeText(this, "Invalid Url", Toast.LENGTH_SHORT).show()
                }
            }
        }

        buttonLoadSample.setOnClickListener {
            webView.loadData(
                sampleHtmlString,
                "text/html",
                "UTF-8"
            )
        }
    }
}
