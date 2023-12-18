package com.example.a07ex11

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap
        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        findViewById<Button>(R.id.buttonHome).setOnClickListener {
            placeRandomMarker("Casa")
        }

        findViewById<Button>(R.id.buttonSchool).setOnClickListener {
            placeRandomMarker("Escola")
        }

        findViewById<Button>(R.id.buttonWork).setOnClickListener {
            placeRandomMarker("Trabalho")
        }
    }

    private fun placeRandomMarker(title: String) {
        val randomLatLng = getRandomLocationNearBarretos()
        googleMap.addMarker(MarkerOptions().position(randomLatLng).title(title))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(randomLatLng, 15f))
    }

    private fun getRandomLocationNearBarretos(): LatLng {
        val center = LatLng(-20.5587, -48.5679) // Centro aproximado de Barretos-SP
        val radius = 3000 // Raio em metros para geração de pontos aleatórios
        val random = Random

        val x0 = center.longitude
        val y0 = center.latitude

        // Convert radius from meters to degrees
        val radiusInDegrees = radius / 111320f

        val u = random.nextDouble()
        val v = random.nextDouble()
        val w = radiusInDegrees * sqrt(u)
        val t = 2 * Math.PI * v
        val x = w * cos(t)
        val newLongitude = x / cos(Math.toRadians(y0))

        val y = w * sin(t)
        val newLatitude = y

        val newLat = newLatitude + y0
        val newLon = newLongitude + x0

        return LatLng(newLat, newLon)
    }

    // Lembre-se de implementar os métodos do ciclo de vida do MapView
    override fun onStart() {
        super.onStart()
        mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        mapView.onPause()
        super.onPause()
    }

    override fun onStop() {
        mapView.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        mapView.onDestroy()
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView.onSaveInstanceState(outState)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}


