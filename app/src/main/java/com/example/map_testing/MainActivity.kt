package com.example.map_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.dublgis.dgismobile.mapsdk.*
import ru.dublgis.dgismobile.mapsdk.Map

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment)
                as MapFragment

        mapFragment.setup(
                apiKey = "Место для ключа",
                zoom = 13.0,
                center = LonLat(37.618317, 55.750574)
        )
        mapFragment.mapReadyCallback = { map: Map? -> map?.let { this.onDGisMapReady(it) } }
    }

    private fun onDGisMapReady(map: Map?) {
        map?.let {
            val marker = it.addMarker(MarkerOptions(
                    LonLat(37.618317, 55.750574),
                    icon = iconFromSvgAsset(assets, "pin.svg"),
                    size = 30.0 to 48.0,
                    anchor = 15.0 to 48.0))

            marker.setOnClickListener {
                Toast.makeText(this, "Hello world", Toast.LENGTH_LONG)
                        .show()
            }
        }
    }
}