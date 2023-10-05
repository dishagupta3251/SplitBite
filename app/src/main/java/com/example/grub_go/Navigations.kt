package com.example.grub_go

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.*

@Composable
fun Navigations(context:Context){

    val navController= rememberNavController()
    NavHost(navController=navController,startDestination= Onboarding.route){
        composable(Onboarding.route)
        { Onboarding(navController,context) }
        composable(Profile.route)
        {
            Profile(navController)
        }
    }
}