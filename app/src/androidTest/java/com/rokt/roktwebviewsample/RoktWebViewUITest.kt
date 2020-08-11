/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsample

import android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.web.sugar.Web.onWebView
import androidx.test.espresso.web.webdriver.DriverAtoms.findElement
import androidx.test.espresso.web.webdriver.DriverAtoms.webClick
import androidx.test.espresso.web.webdriver.Locator
import com.rokt.roktwebviewsdk.RoktWebView
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep

@RunWith(androidx.test.ext.junit.runners.AndroidJUnit4::class)
class RoktWebViewUITest {

    @get:Rule
    val activityTestRule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun externalBrowserShouldBeLaunched() {
        waitUntilCondition(
            onView(
                Matchers.allOf(
                    withId(R.id.webView),
                    ViewMatchers.isAssignableFrom(RoktWebView::class.java)
                )
            ), matches(isDisplayed())
        )

        onView(withId(R.id.buttonLoadSample))
            .perform(click())
            .check(matches(isDisplayed()))

        Intents.intending(IntentMatchers.hasAction(Intent.ACTION_VIEW)).respondWith(
            Instrumentation.ActivityResult(
                Activity.RESULT_OK,
                null
            )
        )

        sleep(100)
        onWebView().withElement(findElement(Locator.ID, "button")).perform(webClick())

        // Check whether the browser intent has been launched
        Intents.intended(
            Matchers.allOf(
                IntentMatchers.hasAction(Intent.ACTION_VIEW),
                IntentMatchers.hasData("https://rokt.com")
            )
        )
    }
}