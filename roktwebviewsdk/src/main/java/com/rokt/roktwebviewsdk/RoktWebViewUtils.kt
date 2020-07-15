/*
 *  Copyright 2020 Rokt Pte Ltd Licensed under the Rokt Software Development Kit (SDK)
 *  Terms of Use Version 2.0 (the "License");
 *
 *  You may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at https://rokt.com/sdk-license-2-0/
 */

package com.rokt.roktwebviewsdk

internal const val WEB_INTERFACE_NAME = "RoktWebViewSDK"

internal val roktUserAgentString: String
    get() = " $WEB_INTERFACE_NAME/${formatVersionName(BuildConfig.VERSION_NAME)}"

/**
 * Converts a semantic string major.minor.patch to the expected format major.minor.
 * Input 1.0.0 will return 1.0
 */
internal fun formatVersionName(versionName: String): String {
    val secondIndex = versionName.indexOf(".", versionName.indexOf(".") + 1)
    return if (secondIndex == -1) {
        versionName
    } else {
        versionName.substring(0, secondIndex)
    }
}