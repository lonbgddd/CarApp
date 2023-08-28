package com.example.carapp.ui.viewModel



import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.car.network.RetroInstance
import com.example.carapp.ui.model.Car
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(): ViewModel() {
    private val _liveDataAllPost = MutableLiveData<Car>()

    val liveDataAllPost: LiveData<Car> =  _liveDataAllPost

    fun getCarAllData() = viewModelScope.launch(Dispatchers.IO) {
        val data = RetroInstance.getRetroInstance().getPostList()
        data.let { res ->
            _liveDataAllPost.postValue(res.body())
        }
    }
}