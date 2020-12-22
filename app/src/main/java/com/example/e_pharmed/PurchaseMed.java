package com.example.e_pharmed;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PurchaseMed extends AppCompatActivity {

    private EditText phoneNumber, IDNo, postalAddress, amount;
    private Button btnbuy, btnscan;
    //private ImageView doc;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchasemed);

        phoneNumber = findViewById(R.id.eTPhoneNo);
        IDNo = findViewById(R.id.eTID_No);
        postalAddress = findViewById(R.id.eTPostalAddress);
        amount = findViewById(R.id.eTAmount);
        btnbuy = findViewById(R.id.btnBuy);
        btnscan = findViewById(R.id.btnScan);
        //doc = findViewById(R.id.iVdocument);

        btnscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PurchaseMed.this,ScanActivity.class));
            }
        });
    }
}
