package com.app.kinonet.custom_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.app.kinonet.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CustomOrderActivity extends AppCompatActivity {

    Button btnPostCustomOrder;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order);


        FloatingActionButton fab = findViewById(R.id.fab_close);
        btnPostCustomOrder = findViewById(R.id.btn_post_custom_order);


        imgBack=findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnPostCustomOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomOrderActivity.this, CustomOrderPostActivity.class);
                startActivity(intent);
            }
        });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
