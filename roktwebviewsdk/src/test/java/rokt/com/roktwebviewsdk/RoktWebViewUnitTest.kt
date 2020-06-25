package rokt.com.roktwebviewsdk

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
