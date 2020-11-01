package com.harsh.printfulapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.harsh.printfulapp.R
import com.harsh.printfulapp.model.User
import com.harsh.printfulapp.ui.adapter.UserInfoWindowAdaptor
import com.harsh.printfulapp.utils.LatLngInterpolator
import com.harsh.printfulapp.utils.MarkerAnimation
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var mMap: GoogleMap
    private val mainViewModel: MainViewModel by viewModels()
    private var usersList: ArrayList<User> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initMap()
        setupObserver()
    }

    private fun initMap() {
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            val serverMessage = mainViewModel.getUsers()

            //Collect StateFlow
            serverMessage.collect {
                if (serverMessage.value.contains("USERLIST")) {
                    val userStr = serverMessage.value.replace("USERLIST", "").trim()
                    val users = userStr.split(";")
                    for (str in users) {
                        if (str.contains(",")) {
                            val userDetails = str.split(",")
                            val tempUser = User(
                                id = userDetails[0],
                                userName = userDetails[1],
                                image = userDetails[2],
                                lat = userDetails[3].toDouble(),
                                lng = userDetails[4].toDouble()
                            )
                            usersList.add(tempUser)
                        }
                    }
                    setUpMarker()
                } else if (serverMessage.value.contains("UPDATE")) {
                    val updateStr = serverMessage.value.replace("UPDATE", "").trim()
                    if (updateStr.contains(",")) {
                        val userUpdates = updateStr.split(",")
                        val currentUserIndex =
                            usersList.indexOfFirst { user -> user.id == userUpdates[0] }
                        val user = usersList[currentUserIndex]

                        user.apply {
                            lat = userUpdates[1].toDouble()
                            lng = userUpdates[2].toDouble()
                        }

                        val newLocation = LatLng(user.lat, user.lng)
                        updateMarkerPosition(newLocation, user)
                    }
                }
            }
        }
    }

    private fun updateMarkerPosition(newLocation: LatLng, user: User) {
        MarkerAnimation.animateMarker(
            user.marker,
            newLocation,
            LatLngInterpolator.Spherical()
        )

        if (user.marker != null && user.marker!!.isInfoWindowShown)
            user.marker!!.showInfoWindow()
    }

    private fun setUpMarker() {
        for (i in 0 until usersList.size) {
            val latLng = LatLng(usersList[i].lat, usersList[i].lng)
            placeMarkerOnMap(latLng, usersList[i])
        }
    }

    private fun placeMarkerOnMap(location: LatLng, user: User) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location, 15.0f))
        val markerOptions = MarkerOptions()
        markerOptions.position(location)
        user.marker = mMap.addMarker(markerOptions)
        user.marker?.tag = user
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setOnMarkerClickListener(this)
        mMap.setInfoWindowAdapter(UserInfoWindowAdaptor(this))
        mainViewModel.fetchUsers()
    }

    override fun onMarkerClick(marker: Marker): Boolean = false
}