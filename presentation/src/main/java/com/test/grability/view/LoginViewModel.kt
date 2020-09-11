package com.test.grability.view
import android.text.TextUtils
import androidx.lifecycle.*

import kotlinx.coroutines.*
import java.util.*
import javax.inject.Inject

class LoginViewModel @Inject constructor(

) : ViewModel() {

    fun validate(email: String, password: String): Boolean {
        if(!(email.isNullOrEmpty() && password.isNullOrEmpty())){
            return isValidEmail(email)
        }
        return false
    }

    fun  isValidEmail(target: String):Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

}