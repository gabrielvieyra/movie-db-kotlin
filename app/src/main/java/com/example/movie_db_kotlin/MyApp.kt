package com.example.movie_db_kotlin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp esto quiere decir que vamos a usar hilt en nuestra aplicacion
@HiltAndroidApp
class MyApp: Application() {
    // Dentro de core vamos a tener la informacion que se comparte en home y en detalle
}