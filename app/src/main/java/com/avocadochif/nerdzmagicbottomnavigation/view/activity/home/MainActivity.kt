package com.avocadochif.nerdzmagicbottomnavigation.view.activity.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.avocadochif.bottomnavigationviewexstension.extensions.onItemReselected
import com.avocadochif.bottomnavigationviewexstension.extensions.onItemSelected
import com.avocadochif.nerdzmagicbottomnavigation.BR
import com.avocadochif.nerdzmagicbottomnavigation.extensions.bindData
import com.avocadochif.nerdzmagicbottomnavigation.R
import com.avocadochif.nerdzmagicbottomnavigation.databinding.ActivityMainBinding
import com.avocadochif.nerdzmagicbottomnavigation.extensions.obs
import com.avocadochif.nerdzmagicbottomnavigation.extensions.replaceFragment
import com.avocadochif.nerdzmagicbottomnavigation.view.fragment.events.EventsFragment
import com.avocadochif.nerdzmagicbottomnavigation.view.fragment.home.HomeFragment
import com.avocadochif.nerdzmagicbottomnavigation.view.fragment.library.LibraryFragment
import com.avocadochif.nerdzmagicbottomnavigation.viewmodel.home.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.bindData(BR.viewmodel, viewModel)

        initViews()
        initObservers()
    }

    private fun initViews() {
        initBottomNavigation()
    }

    private fun initObservers() {
        viewModel.homeItemClickedLD.obs(this) { replaceFragment(R.id.homeContainer, HomeFragment(), false) }
        viewModel.eventsItemClickedLD.obs(this) { replaceFragment(R.id.homeContainer, EventsFragment(), false) }
        viewModel.libraryItemClickedLD.obs(this) { replaceFragment(R.id.homeContainer, LibraryFragment(), false) }
    }

    private fun initBottomNavigation() {
        bottomNavigation.onItemSelected { viewModel.onBottomItemChanged(it) }
        bottomNavigation.onItemReselected { }
        replaceFragment(R.id.homeContainer, HomeFragment(), false)
    }

}