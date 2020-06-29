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
import com.yurvan.newsbinar.databinding.FragmentDesignBinding
import com.yurvan.newsbinar.feature.home.adapter.SourcesAdapter


class SourcesFragment : BaseHomeFragment() {

    companion object {
        fun newInstance(): SourcesFragment {
            return SourcesFragment()
        }
    }

    private lateinit var binding: FragmentDesignBinding

    private val sourcesAdapter: SourcesAdapter by lazy {
        SourcesAdapter{
            goToDetail(it.url, it.name)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_design, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@SourcesFragment.sourcesAdapter
            setHasFixedSize(true)
        }

        viewModel.requestSources()

        viewModel.getLoading().observe(this, Observer {
            if (it) LoadingDialog.show(activity) else LoadingDialog.dismiss()
        })

        viewModel.sources.observe(this, Observer {
            sourcesAdapter.loadData(it)
        })


    }


}
