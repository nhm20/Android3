package com.example.googlemapsandroidproject

import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class GeoCoderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_geo_coder)
        val addressInput = findViewById<EditText>(R.id.addressInput)
        val geoButton = findViewById<Button>(R.id.geoButton)
        val reverseGeoButton = findViewById<Button>(R.id.reverseGeoButton)
        val outputText = findViewById<TextView>(R.id.outputText)
        val geocoder = Geocoder(this, Locale.getDefault())

        // 🌍 Geocoding - Get Coordinates from Address
        geoButton.setOnClickListener {
            val address = addressInput.text.toString()
            if (address.isNotEmpty()) {
                val location = geocoder.getFromLocationName(address,
                    1)
                if (!location.isNullOrEmpty()) {
                    val lat = location[0].latitude
                    val lon = location[0].longitude
                    outputText.text = "Latitude: $lat\nLongitude: $lon"
                } else {
                    outputText.text = "No location found"
                }
            } else {
                Toast.makeText(this, "Enter an address",
                    Toast.LENGTH_SHORT).show()
            }
        }

        // 📍 Reverse Geocoding - Get Address from Coordinates
        reverseGeoButton.setOnClickListener {
            try {
                val lat = 28.6139  // Example: New Delhi
                val lon = 77.2090
                val addresses = geocoder.getFromLocation(lat, lon,
                    1)
                if (!addresses.isNullOrEmpty()) {
                    val address = addresses[0].getAddressLine(0)
                    outputText.text = "Address: $address"
                } else {
                    outputText.text = "No address found"
                }
            } catch (e: Exception) {
                e.printStackTrace()
                outputText.text = "Error: ${e.message}"
            }
        }
    }
}
