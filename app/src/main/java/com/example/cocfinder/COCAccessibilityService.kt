package com.example.cocfinder

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent

class COCAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d("COCService", "Event received: ${event?.eventType}")
    }

    override fun onInterrupt() {
        Log.d("COCService", "Service interrupted")
    }
}