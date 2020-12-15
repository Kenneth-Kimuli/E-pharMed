package com.example.e_pharmed;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class UserLoginActivity extends AppCompatActivity {

    private Button login;
    private EditText user_name;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        viewsSetup();
        userAuth();

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(UserLoginActivity.this, PharmacyActivity.class);
                // myIntent.putExtra("key", value); //Optional parameters
                UserLoginActivity.this.startActivity(myIntent);
            }
        });
    }

    public void viewsSetup(){
        login = findViewById(R.id.loginButton);
        user_name = findViewById(R.id.eTusername);
        password = findViewById(R.id.eTusername);

        //user_name.getText().toString();
        //password.getText().toString();

    }

    public void userAuth(){
        if (user_name.getText().toString().equals("Kenneth") && password.getText().toString().equals("1234")){

            Toast.makeText(this, "Log in successful", Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
        }

    }
}
