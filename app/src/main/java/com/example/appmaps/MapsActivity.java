package com.example.appmaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.appmaps.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    double numLatitud;
    double numLongitud;
    double numZoom;

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

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value1 = extras.getString("lati");
            numLatitud = Double.valueOf(value1);
            String value2 = extras.getString("longi");
            numLongitud = Double.valueOf(value2);
            String value3 = extras.getString("zoom");
            numZoom = Double.valueOf(value3);


        }

        LatLng ubicacion = new LatLng(numLatitud, numLongitud);
        mMap.addMarker(new MarkerOptions().position(ubicacion).title("Ubicación Seleccionada").icon(BitmapDescriptorFactory.defaultMarker()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacion));

        //Camara foco y zoom
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion,(float) numZoom));


    }
}