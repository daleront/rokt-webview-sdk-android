/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsdk

import org.junit.Assert.assertEquals
import org.junit.Test

class RoktWebViewUnitTest {

    @Test
    fun `when provided a valid string, formatVersionName should remove extra characters`() {
        assertEquals("1.0", formatVersionName("1.0.0"))
        assertEquals("1.0", formatVersionName("1.0"))
        assertEquals("1.2", formatVersionName("1.2.323"))
        assertEquals("1.0", formatVersionName("1.0.0.0"))
    }

    @Test
    fun `when provided an empty string, formatVersionName should return an empty String`() {
        assertEquals("", formatVersionName(""))
    }

    @Test
    fun `roktUserAgentString is in the correct format`() {
        assertEquals(
            " RoktWebViewSDK/${formatVersionName(BuildConfig.VERSION_NAME)}",
            roktUserAgentString
        )
    }
}
