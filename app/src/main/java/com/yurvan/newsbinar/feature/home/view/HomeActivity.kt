package com.yurvan.newsbinar.feature.home.view


import android.os.Bundle

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.yurvan.newsbinar.R
import dagger.Module
import dagger.android.ContributesAndroidInjector

import com.yurvan.newsbinar.core.di.FragmentScoped
import com.yurvan.newsbinar.core.platform.BaseActivity
import com.yurvan.newsbinar.databinding.ActivityHomeBinding
import com.yurvan.newsbinar.feature.about.AboutActivity



class HomeActivity : BaseActivity<ActivityHomeBinding>(R.layout.activity_home) {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        initViewPager()
    }

    private fun initViewPager() {
        viewPager = binding.viewPager
        viewPager.adapter = NewsPagerAdapter(supportFragmentManager)
        binding.tabLayout.setupWithViewPager(viewPager)

        val position = 0
        viewPager.apply {
            currentItem = position
            offscreenPageLimit = 4
        }

    }

    inner class NewsPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
        private var headlineFragment: HeadlineFragment = HeadlineFragment.newInstance()
        private var androidFragment: EverythingFragment = EverythingFragment.newInstance()
        private var designFragment: SourcesFragment = SourcesFragment.newInstance()


        override fun getCount(): Int {
            return 3
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> headlineFragment
                1 -> androidFragment
                else -> designFragment

            }
        }


        override fun getPageTitle(position: Int): CharSequence? {
            return when (position) {
                0 -> "Headline"
                1 -> "Everything"
                else -> "Sources"
            }

        }

    }



}

@Module
abstract class HomeActivityModule{
    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeHeadlineFragment(): HeadlineFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeAndroidFragment(): EverythingFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeDesignFragment(): SourcesFragment
}
