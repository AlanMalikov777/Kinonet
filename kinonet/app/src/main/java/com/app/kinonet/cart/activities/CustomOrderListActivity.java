package com.app.kinonet.cart.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.kinonet.cart.adapter.CustomOrderListAdapter;
import com.app.kinonet.R;

public class CustomOrderListActivity extends AppCompatActivity {

    String foodItemList[] = {"Pasta", "Pizza",};
    double foodPriceList[] = {96.00, 120.00};
    int imgList[] = {R.drawable.ic_item_1, R.drawable.ic_item_2};
    RecyclerView recyclerView;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order_list);


        // get the reference of RecyclerView
        recyclerView = findViewById(R.id.recycler_view);


        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(linearLayoutManager);

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomOrderListAdapter customAdapter = new CustomOrderListAdapter(this, foodItemList, foodPriceList, imgList);
        recyclerView.setAdapter(customAdapter);


        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
