package com.test.grability.data.remote.util

import com.test.grability.data.BuildConfig

class MarvelAPIUtils {

    private fun generateHash(timestamp: Long): String {
        val toHash: String = timestamp.toString()
            .plus(BuildConfig.MARVEL_API_PRIVATE_KEY)
            .plus(BuildConfig.MARVEL_API_PUBLIC_KEY)
        return toHash.toMD5()
    }

    private fun generateTimestamp(): Long {
        return System.currentTimeMillis()
    }

    fun getAuthorizationValues(): Triple<String, String,String> {
        val timeStamp = generateTimestamp()
        val hash = generateHash(timeStamp)
        val key = BuildConfig.MARVEL_API_PUBLIC_KEY
        return Triple(timeStamp.toString(),key, hash)
    }

}