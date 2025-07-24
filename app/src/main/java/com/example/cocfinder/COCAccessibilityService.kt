package com.example.cocfinder

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class COCAccessibilityService : AccessibilityService() {

    private val cocPackage = "com.supercell.clashofclans"

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return

        // Check if COC is the current package
        if (event.packageName != cocPackage) return

        Log.d("COCService", "COC Event: ${event.eventType}")

        val rootNode = rootInActiveWindow ?: return

        // Recursively log visible text content
        logVisibleText(rootNode)
    }

    private fun logVisibleText(node: AccessibilityNodeInfo) {
        if (node.text != null && node.text.isNotBlank()) {
            Log.d("COCService", "Node Text: ${node.text}")
        }

        for (i in 0 until node.childCount) {
            node.getChild(i)?.let { logVisibleText(it) }
        }
    }

    override fun onInterrupt() {
        Log.d("COCService", "AccessibilityService Interrupted")
    }
}
