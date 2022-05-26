package com.app.kinonet.custom_order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.kinonet.R;

public class CustomOrderPostActivity extends AppCompatActivity {

    Button btnPostOrder;

    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_order_post);


        btnPostOrder = findViewById(R.id.btn_post_order);

        imgBack=findViewById(R.id.img_back);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        btnPostOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomOrderPostActivity.this, OrderCompleteActivity.class);
                startActivity(intent);
            }
        });

    }
}
