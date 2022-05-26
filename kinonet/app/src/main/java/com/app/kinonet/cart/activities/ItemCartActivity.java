package com.app.kinonet.cart.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.R;
import com.app.kinonet.cart.adapter.ItemCartAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ItemCartActivity extends AppCompatActivity implements OnMapReadyCallback {


    String foodItemList[] = {"Grilled salmon", "Pasta Ham"};
    double foodPriceList[] = {96.00, 120.00};
    int imgList[] = {R.drawable.img_food_1, R.drawable.img_food_2};
    RecyclerView recyclerView;
    LinearLayout layoutItemCart, layoutCard;
    ImageView imgBack;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_cart);

        // get the reference of RecyclerView
        recyclerView = findViewById(R.id.recycler_view);
        layoutItemCart = findViewById(R.id.layout_item_cart);
        layoutCard = findViewById(R.id.layout8);

        imgBack = findViewById(R.id.img_back);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ItemCartActivity.this);


        recyclerView.setLayoutManager(linearLayoutManager);

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        ItemCartAdapter customAdapter = new ItemCartAdapter(ItemCartActivity.this, foodItemList, foodPriceList, imgList);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(ItemCartActivity.this);

        layoutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemCartActivity.this, AddCardActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng latLng = new LatLng(38.907192, -77.036873);
        mMap.addMarker(new MarkerOptions().position(latLng));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        //for normal map view
        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);

        //for add zoom in maps
        float zoomLevel = 16.0f; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
    }
}
