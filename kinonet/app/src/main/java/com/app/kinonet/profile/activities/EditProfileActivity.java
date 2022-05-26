package com.app.kinonet.profile.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.kinonet.R;

public class EditProfileActivity extends AppCompatActivity {

    ImageView imgBack;
    TextView txtSave, txtName;
    EditText etxtEmail, etxtPhone, etxtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        txtName = findViewById(R.id.txt_name);
        imgBack = findViewById(R.id.img_back);
        txtSave = findViewById(R.id.txt_save);
        etxtEmail = findViewById(R.id.etxt_email);
        etxtAddress = findViewById(R.id.etxt_address);
        etxtPhone = findViewById(R.id.etxt_phone);


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(EditProfileActivity.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
                etxtEmail.setEnabled(false);
                etxtAddress.setEnabled(false);
                etxtPhone.setEnabled(false);
            }
        });


    }
}
