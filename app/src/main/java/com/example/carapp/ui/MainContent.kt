package com.example.carapp.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carapp.ui.model.Car
import com.example.carapp.ui.model.CarElement
import com.example.carapp.ui.viewModel.HomeViewModel
import com.example.carapp.ui.views.DetailCar
import com.example.carapp.ui.views.HomeScreen

@Composable
fun MainContent() {
    val navController = rememberNavController()
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
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

@Composable
fun GoToNextPage(navController: NavController? = null) {
    Button(onClick = { navController?.navigate("home") }) {
        Text(text = "Chuyen man")
    }
}