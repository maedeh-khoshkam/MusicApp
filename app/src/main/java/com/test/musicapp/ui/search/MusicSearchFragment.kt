package com.test.musicapp.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.domain.models.MusicParams
import com.test.domain.models.MusicResponseUiMode
import com.test.musicapp.R
import com.test.musicapp.base.BaseFragment
import com.test.musicapp.databinding.FragmentMusicSearchBinding
import com.test.musicapp.extension.gone
import com.test.musicapp.extension.observe
import com.test.musicapp.extension.visible
import com.test.presentation.viewModel.MusicSearchViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MusicSearchFragment : BaseFragment<FragmentMusicSearchBinding, MusicSearchViewModel>() {


    @Inject
    lateinit var mAdapter: MusicSearchAdapter
    override val mViewModel: MusicSearchViewModel by viewModels()

    override fun getViewBinding(): FragmentMusicSearchBinding = FragmentMusicSearchBinding.inflate(
        LayoutInflater.from(requireContext())
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observe(mViewModel.musicList, ::onViewStateChange)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSearchField()
    }

    private fun setUpSearchField() {
        mBinding.etSearch.addTextChangedListener {
            getMusicList(it.toString())
        }
    }

    private fun getMusicList(term: String) {
        val params = MusicParams(term, getString(R.string.str_country))
        mViewModel.getMusicList(params)
    }

    private fun setUpRecyclerView() {
        mBinding.list.apply {
            adapter = mAdapter
            val mLinearLayoutManager = LinearLayoutManager(requireContext())
            layoutManager = mLinearLayoutManager

            mAdapter.setItemClickListener { item ->

            }
        }
    }

    private fun onViewStateChange(event: MusicResponseUiMode) {
        if (event.isRedelivered) return
        when (event) {
            is MusicResponseUiMode.Loading -> {
                mBinding.loading.visible()
            }
            is MusicResponseUiMode.Success -> {
                mBinding.loading.gone()
                mAdapter.list = event.data.results
            }
            is MusicResponseUiMode.Error -> {
                mBinding.loading.gone()
            }
        }
    }


}