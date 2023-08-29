package com.example.carapp.ui.views.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun DetailCar(elementId: String, navController: NavController? = null) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .clickable { navController?.popBackStack() }

    ) {
        Text(text = elementId.toString())
    }
}