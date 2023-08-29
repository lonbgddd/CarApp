package com.example.carapp.ui.views.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.carapp.ui.Screens
import com.example.carapp.ui.model.CarElement

@Composable
fun HomeScreen(navController: NavController? = null, lists: List<CarElement> = emptyList()) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            TopHeader()
        }
        item { FilterBox() }
        ListCar(lists = lists, navController = navController)
    }

}


fun LazyListScope.ListCar(
    navController: NavController? = null,
    lists: List<CarElement> = emptyList()
) {
    items(items = lists) {
        ListItem(
            car = it,
            navController = navController)
    }

}

@Composable
fun ListItem(
    car: CarElement,
    navController: NavController? = null
) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Card(modifier = Modifier.clickable { navController?.navigate(Screens.Detail.createRoute(elementId = "${car.avatar}")) }) {
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

@Composable
fun FilterBox(){
    Box (
        modifier = Modifier.fillMaxWidth().border(color = Color.Black, width = 2.dp).background(color = Color.White),
        contentAlignment = Alignment.Center,

            ){
        Text(text = "Chao banj")
    }
}
@Composable
fun TopHeader(navController: NavController? = null) {
    Row(
        modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 20.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column() {
            Text(text = "Your location")
            Text(
                text = "Your location",
                style = TextStyle(color = Color.Black, fontWeight = FontWeight(23))
            )
        }
        AsyncImage(
            model = "https://znews-photo.zingcdn.me/w660/Uploaded/kbd_pilk/2022_09_22/tieu_long_nu1.jpg",
            contentDescription = "Anh mang",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .border(BorderStroke(1.dp, Color.Black)),
            contentScale = ContentScale.Crop
        )

    }
}