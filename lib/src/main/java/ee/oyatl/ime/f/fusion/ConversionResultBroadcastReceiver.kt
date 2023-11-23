package ee.oyatl.ime.f.fusion

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import ee.oyatl.ime.f.fusion.Constants.EXTRA_CANDIDATES

/**
 * Client side, receives conversion result from Converter
 */
class ConversionResultBroadcastReceiver(
    private val listener: Listener
): BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        context ?: return
        intent ?: return
        val candidates = intent.getStringArrayListExtra(EXTRA_CANDIDATES)
            ?.map { it.split('\t') }.orEmpty()
        listener.onCandidates(candidates)
    }

    interface Listener {
        fun onCandidates(candidates: List<List<String>>)
    }
}