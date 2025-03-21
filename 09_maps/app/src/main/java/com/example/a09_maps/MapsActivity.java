package com.example.a09_maps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.a09_maps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        LatLng home = new LatLng(16.47678, 80.72117);
        mMap.addMarker(new MarkerOptions().position(home).title("Marker at Vignesh's Home"));
        LatLng college = new LatLng(16.4876606, 80.6941328);
        mMap.addMarker(new MarkerOptions().position(college).title("Marker at PVPSIT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(college));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(home, 15));
        mMap.getUiSettings().setZoomGesturesEnabled(true);
    }
}