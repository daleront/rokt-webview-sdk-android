package rokt.com.roktwebviewsdk

import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView

open class RoktWebview @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr)