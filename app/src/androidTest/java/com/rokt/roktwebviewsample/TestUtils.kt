/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsample

import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction

private const val WAIT_TIME_TICK = 300L
private const val WAIT_TIME_TOTAL = 10000L

fun waitUntilCondition(
    viewInteraction: ViewInteraction,
    viewAssertion: ViewAssertion,
    extraTimeoutMs: Long = 0L
) {
    val startTime = System.currentTimeMillis()

    fun hasMaximumTimeExceeded() =
        System.currentTimeMillis() - startTime > WAIT_TIME_TOTAL + extraTimeoutMs

    while (true) {
        try {
            var errorThrowable: Throwable? = null
            viewInteraction.withFailureHandler { error, _ ->
                errorThrowable = error
            }.check(viewAssertion)

            if (errorThrowable == null) {
                return
            } else if (hasMaximumTimeExceeded()) {
                throw errorThrowable!!
            }
        } catch (e: Exception) {
            throw e
        }

        Thread.sleep(WAIT_TIME_TICK)
    }
}
