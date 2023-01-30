package com.test.musicapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.test.musicapp.extension.showSnackBar
import com.test.presentation.viewModel.BaseViewModel
import timber.log.Timber

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {


    protected lateinit var mBinding: VB
    protected abstract val mViewModel: VM


    abstract fun getViewBinding(): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        mBinding = getViewBinding()
        return mBinding.root
    }

    protected open fun handleErrorMessage(message: String?) {
        if (message.isNullOrBlank()) return
        Timber.e(message)
        showSnackBar(mBinding.root, message)
    }

}