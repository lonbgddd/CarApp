package com.example.carapp.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carapp.ui.views.home.viewModel.HomeViewModel
import com.example.carapp.ui.views.detail.DetailCar
import com.example.carapp.ui.views.home.HomeScreen

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFE6F4EA)
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable(Screens.Home.router) {
                val viewModel: HomeViewModel = viewModel()
                viewModel.getCarAllData()
                val list by viewModel.liveDataAllPost.observeAsState(emptyList())
                Log.d("TAG", "MainContent: $list")
                HomeScreen(navController, list)
            }
            composable(Screens.Detail.router) {
                val elementId = it.arguments?.getString("elementId")
                Log.d("TAG", "MainContent: $elementId")
                if (elementId == null){
                    Toast.makeText(LocalContext.current, "Cant find id", Toast.LENGTH_SHORT).show()
                } else {
                    DetailCar(elementId = elementId, navController)
                }
            }
        }
    }
}