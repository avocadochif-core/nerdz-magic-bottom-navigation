package com.avocadochif.nerdzmagicbottomnavigation.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.avocadochif.nerdzmagicbottomnavigation.enums.BottomNavigationPage.*
import com.avocadochif.nerdzmagicbottomnavigation.extensions.execute

class HomeViewModel : ViewModel() {

    /////////////////////////////////////////////////////////
    ///////////////// Live Data with getters ////////////////
    /////////////////////////////////////////////////////////

    private val _homeItemClickedLD = MutableLiveData<Unit>()
    val homeItemClickedLD: LiveData<Unit> get() = _homeItemClickedLD

    private val _eventsItemClickedLD = MutableLiveData<Unit>()
    val eventsItemClickedLD: LiveData<Unit> get() = _eventsItemClickedLD

    private val _libraryItemClickedLD = MutableLiveData<Unit>()
    val libraryItemClickedLD: LiveData<Unit> get() = _libraryItemClickedLD

    /////////////////////////////////////////////////////////
    ///////////////////////// Calls /////////////////////////
    /////////////////////////////////////////////////////////

    fun onBottomItemChanged(position: Int) {
        when(values()[position]) {
            TAB_HOME -> _homeItemClickedLD.execute()
            TAB_EVENTS -> _eventsItemClickedLD.execute()
            TAB_LIBRARY -> _libraryItemClickedLD.execute()
        }
    }

}