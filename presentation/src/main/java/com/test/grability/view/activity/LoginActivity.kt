package com.test.grability.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.test.grability.R
import com.test.grability.databinding.ActivityLoginBinding
import com.test.grability.di.util.lazyThreadSafetyNone
import com.test.grability.base.BaseActivity
import com.test.grability.view.LoginViewModel
import javax.inject.Inject

class LoginActivity : BaseActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazyThreadSafetyNone {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    
    override fun observeViewModel() {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.fabClick = this

    }

    override fun initViewBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onClick(v: View?) {
        if(viewModel.validate(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString())) {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
        }else{
            Snackbar.make(
                binding.root,
                getString(R.string.noempty),
                Snackbar.LENGTH_LONG
            ).show()

        }

    }

}