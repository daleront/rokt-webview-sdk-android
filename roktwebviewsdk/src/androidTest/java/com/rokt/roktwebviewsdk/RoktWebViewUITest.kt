package com.rokt.roktwebviewsdk

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoktWebViewUITest {

    private val context: Context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun roktWebViewShouldSetUserAgentCorrectly() {
        runOnUiThread {
            val roktWebView = RoktWebView(context)
            assertTrue(roktWebView.settings.userAgentString.contains(roktUserAgentString))
        }
    }

    @Test
    fun roktWebViewShouldEnableJavascript() {
        runOnUiThread {
            val roktWebView = RoktWebView(context)
            assertTrue(roktWebView.settings.javaScriptEnabled)
        }
    }
}
