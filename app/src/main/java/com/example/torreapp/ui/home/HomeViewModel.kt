package com.example.torreapp.ui.home

import android.app.Application
import android.widget.ListView
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.torreapp.adapter.OpportunityAdapter
import com.example.torreapp.model.Opportunity
import com.example.torreapp.service.TorreAPIService
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlin.concurrent.thread
import kotlin.coroutines.coroutineContext

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    internal val oppList = MutableLiveData<ArrayList<Opportunity>>()
//
//    private val opportunityList: MutableLiveData<ArrayList<Opportunity>> by lazy {
//        MutableLiveData<ArrayList<Opportunity>>().also {
//            loadOpportunities()
//        }
//    }
    fun getOpportunities(homeViewModel: HomeViewModel, listView: ListView): LiveData<ArrayList<Opportunity>> {

        oppList.value = TorreAPIService.getOpporunities(getApplication<Application>().applicationContext,
            homeViewModel, listView)
        return oppList
    }

}