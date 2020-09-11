package com.test.grability.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.test.grability.R

import dagger.android.support.AndroidSupportInjection
import dagger.android.support.DaggerFragment

abstract class BaseFragment<T : ViewDataBinding> : DaggerFragment() {

    private lateinit var viewDataBinding: T

    fun getViewDataBinding(): T {
        return viewDataBinding
    }

    protected abstract fun initializeViewModel()

    abstract val layoutId: Int

    abstract fun observeViewModel()

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        getViewDataBinding().lifecycleOwner = this
        getViewDataBinding().executePendingBindings()
        initializeViewModel()
        observeViewModel()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        return viewDataBinding.root
    }


    fun setTitle(title: String) {
        val actionBar = (activity as BaseActivity).supportActionBar
        if (actionBar != null) {
            val titleTextView = activity?.findViewById<TextView>(R.id.txt_toolbar_title)
            if (title.isNotEmpty()) {
                titleTextView?.text = title
            }
        }
    }



}
