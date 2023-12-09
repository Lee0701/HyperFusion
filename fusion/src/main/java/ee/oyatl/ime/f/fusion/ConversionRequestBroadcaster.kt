package ee.oyatl.ime.f.fusion

import android.content.Context
import android.content.Intent
import ee.oyatl.ime.f.fusion.Constants.ACTION_CONVERT_TEXT
import ee.oyatl.ime.f.fusion.Constants.EXTRA_TEXT
import ee.oyatl.ime.f.fusion.Constants.EXTRA_VERSION
import ee.oyatl.ime.f.fusion.Constants.PERMISSION_CONVERT_TEXT

/**
 * Client side to Converter side, requests text conversion
 */
object ConversionRequestBroadcaster {
    fun broadcast(context: Context, text: String) {
        val intent = Intent().apply {
            action = ACTION_CONVERT_TEXT
            putExtra(EXTRA_TEXT, text)
            putExtra(EXTRA_VERSION, context.resources.getInteger(R.integer.hyperfusion_version))
        }
        context.sendBroadcast(intent, PERMISSION_CONVERT_TEXT)
    }
}