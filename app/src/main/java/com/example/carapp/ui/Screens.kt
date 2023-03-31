package com.example.carapp.ui

sealed class Screens(val router: String){
    object Detail: Screens("detail/{elementId}"){
        fun createRoute(elementId: String)= "detail/$elementId"
    }
    object Home: Screens("home")
}
