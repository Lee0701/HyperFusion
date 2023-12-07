package ee.oyatl.ime.f.fusion

import android.content.Context
import android.content.Intent
import ee.oyatl.ime.f.fusion.Constants.ACTION_CONVERT_TEXT_RESULT
import ee.oyatl.ime.f.fusion.Constants.EXTRA_CANDIDATES
import ee.oyatl.ime.f.fusion.Constants.PERMISSION_RECEIVE_CONVERTED_TEXT

/**
 * Converter side to Client side, broadcasts converted result to client
 */
object ConversionResultBroadcaster {
    fun broadcast(context: Context, candidates: List<List<String>>) {
        val intent = Intent().apply {
            action = ACTION_CONVERT_TEXT_RESULT
            val result = ArrayList(candidates.map { item -> item.joinToString("\t") })
            putExtra(EXTRA_CANDIDATES, result)
        }
        context.sendBroadcast(intent, PERMISSION_RECEIVE_CONVERTED_TEXT)
    }
}