package com.harsh.printfulapp.model

import com.google.android.gms.maps.model.Marker

class User(
    var id: String,
    var userName: String,
    var image: String,
    var lat: Double,
    var lng: Double,
    var marker: Marker? = null
)