package ee.oyatl.ime.f.fusion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ee.oyatl.ime.f.fusion.Constants.EXTRA_TEXT

/**
 * Converter side, receives request from client and pass it to the conversion engine
 */
class ConversionRequestBroadcastReceiver(
    private val listener: Listener
): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context ?: return
        intent ?: return
        val text = intent.getStringExtra(EXTRA_TEXT) ?: return
        listener.onText(text)
    }

    interface Listener {
        fun onText(text: String)
    }
}