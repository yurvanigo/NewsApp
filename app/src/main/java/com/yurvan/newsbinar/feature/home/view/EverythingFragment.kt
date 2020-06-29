package com.yurvan.newsbinar.feature.home.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.yurvan.newsbinar.R


import com.yurvan.newsbinar.core.platform.BaseHomeFragment

import com.yurvan.newsbinar.core.utils.LoadingDialog
import com.yurvan.newsbinar.databinding.FragmentAndroidBinding

class EverythingFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): EverythingFragment {
            return EverythingFragment()
        }
    }

    private lateinit var binding: FragmentAndroidBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_android, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@EverythingFragment.adapter
            setHasFixedSize(true)
        }

        viewModel.requestEverything()

        viewModel.getLoading().observe(this, Observer {
            if (it) LoadingDialog.show(activity) else LoadingDialog.dismiss()
        })

        viewModel.everything.observe(this, Observer {
            adapter.loadData(it)
        })
    }

}
