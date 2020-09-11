package com.test.grability.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.grability.R
import com.test.grability.base.BaseActivity
import com.test.grability.databinding.ActivityLoginBinding
import com.test.grability.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun observeViewModel() {
    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


}
