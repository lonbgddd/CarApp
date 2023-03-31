package com.example.carapp.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.carapp.ui.Screens
import com.example.carapp.ui.model.Car
import com.example.carapp.ui.model.CarElement
import com.example.carapp.ui.viewModel.HomeViewModel

@Composable
fun HomeScreen(navController: NavController? = null, lists: List<CarElement> = emptyList()) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = lists) {
            ListItem(car = it, navController)
        }
    }

}

@Composable
fun ListItem(car: CarElement, navController: NavController? = null) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Card(modifier = Modifier.clickable { navController?.navigate(Screens.Detail.createRoute(car.avatar!!)) }) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                car.name?.let { Text(text = it) }
            }
        }
    }
}