package com.test.grability

import android.content.Context
import androidx.multidex.MultiDex
import com.test.grability.di.DaggerApplication

class App:  DaggerApplication() {

    companion object {
        private const val LOG_TAG = "Marvel"
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
