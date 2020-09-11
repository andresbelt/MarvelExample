package com.test.grability.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar
import com.test.grability.R
import com.test.grability.adapter.CharactersPagedListAdapter
import com.test.grability.base.BaseFragment
import com.test.grability.data.vo.UiState
import com.test.grability.databinding.FragmentHomeBinding
import com.test.grability.domain.entities.Characters
import com.test.grability.domain.vo.ResponseResult
import javax.inject.Inject


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var factory : ViewModelProvider.Factory

    lateinit var homeViewModel : HomeViewModel

    override val layoutId: Int
        get() = R.layout.fragment_home

    private val charactersAdapter by lazy { CharactersPagedListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        homeViewModel.setSearchQuery()

    }

    private fun subscribeNewsState(it: ResponseResult<List<Characters>>) {
        when(it) {
            is ResponseResult.Loading -> {

                getViewDataBinding().progressBar.visibility = View.VISIBLE
                charactersAdapter.setState(UiState.Loading)}
            is ResponseResult.Success -> {

                getViewDataBinding().progressBar.visibility = View.GONE
                charactersAdapter.setState(UiState.Success)}
            is ResponseResult.Error -> {

                getViewDataBinding().progressBar.visibility = View.GONE
                charactersAdapter.setState(UiState.Error)
                Snackbar.make(
                    getViewDataBinding().root,
                    it.errorMessage ?: "",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

    }

    private fun initRecyclerView() {
        val layoutManager = LinearLayoutManager(
            requireActivity(),
            LinearLayoutManager.VERTICAL,
            false
        )
        getViewDataBinding().recyclerView.layoutManager = layoutManager
        getViewDataBinding().recyclerView.isNestedScrollingEnabled = false
        getViewDataBinding().recyclerView.adapter = charactersAdapter


    }



    private fun subscribeNews(data: PagedList<Characters>) {
        charactersAdapter.submitList(data)
    }

    override fun observeViewModel() {

        homeViewModel.searchState.observe(viewLifecycleOwner, Observer { subscribeNewsState(it) })

        homeViewModel.search().characters.observe(viewLifecycleOwner, Observer { subscribeNews(it) })

    }

    override fun initializeViewModel() {

        homeViewModel = ViewModelProviders.of(this, factory).get(HomeViewModel::class.java)
    }
}
