package com.example.carapp.ui.views.home.viewModel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carapp.data.network.RetroInstance
import com.example.carapp.ui.model.Car
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
@HiltViewModel
class HomeViewModel(): ViewModel() {
    private val _liveDataAllPost = MutableLiveData<Car>()

    val liveDataAllPost: LiveData<Car> =  _liveDataAllPost

    fun getCarAllData() = viewModelScope.launch(Dispatchers.IO) {
        val data = RetroInstance.getRetroInstance().getPostList()

    }
}