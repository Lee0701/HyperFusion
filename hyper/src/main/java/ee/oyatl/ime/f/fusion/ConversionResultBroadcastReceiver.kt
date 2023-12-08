package ee.oyatl.ime.f.fusion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ee.oyatl.ime.f.fusion.Constants.EXTRA_CANDIDATES
import ee.oyatl.ime.f.fusion.Constants.EXTRA_VERSION

/**
 * Client side, receives conversion result from Converter
 */
class ConversionResultBroadcastReceiver(
    private val listener: Listener
): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context ?: return
        intent ?: return
        val receivedVersion = intent.getIntExtra(EXTRA_VERSION, 0)
        if(receivedVersion >= 1) {
            val candidates = intent.getStringArrayListExtra(EXTRA_CANDIDATES)
                ?.map { it.split('\t') }.orEmpty()
            listener.onCandidates(candidates)
        }
    }

    interface Listener {
        fun onCandidates(candidates: List<List<String>>) = Unit
    }
}