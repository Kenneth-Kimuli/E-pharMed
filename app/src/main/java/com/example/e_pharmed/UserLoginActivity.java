package com.example.e_pharmed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLoginActivity extends AppCompatActivity {

   /* private Button login;
    private EditText user_name;
    private EditText password;
    private TextView forgot_pw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        viewsSetup();

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                userAuth();
            }
        });
    }

    public void viewsSetup(){
        login = findViewById(R.id.loginButton);
        user_name = findViewById(R.id.eTusername);
        password = findViewById(R.id.eTpwd);

        //user_name.getText().toString();
        //password.getText().toString();

    }

    public void userAuth(){
        if (user_name.getText().toString().equals("Kenneth") && password.getText().toString().equals("1234")){

            Toast.makeText(this, "Log in successful", Toast.LENGTH_SHORT).show();

            Intent myIntent = new Intent(UserLoginActivity.this, PharmacyActivity.class);
            UserLoginActivity.this.startActivity(myIntent);

        }else {

            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            //todo: refresh login page, option to register user, forgot pwd

        }

    }*/

    private EditText Email;
    private EditText Password;
    private Button LogIn;
    private TextView SignUp;
    private FirebaseAuth firebaseAuth;
    //since verification may take a while, we can display a message to user
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        Email = (EditText) findViewById(R.id.etEmail);
        Password = (EditText) findViewById(R.id.etPassword);
        LogIn = (Button) findViewById(R.id.btnLogIn);
        SignUp = (TextView) findViewById(R.id.tvSignUp);


        firebaseAuth = FirebaseAuth.getInstance();

        //object of main class,
        FirebaseUser user = firebaseAuth.getCurrentUser();
        progressDialog = new ProgressDialog(this);

        //checks with db if user has already logged in, must direct him to next activity without asking him to login again
        if (user != null) {
            finish();
            startActivity(new Intent(UserLoginActivity.this, PharmacyActivity.class));
        }

        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserLoginActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
    private void validate() {
        String emailstr = Email.getText().toString();
        String passwordstr = Password.getText().toString();

        //message to user on what's going on; clue
        progressDialog.setMessage("This might take a while...");
        progressDialog.show();

        if (emailstr.isEmpty()) {
            Toast.makeText(this, "Please enter your Email", Toast.LENGTH_SHORT).show();
        } else if (passwordstr.isEmpty()) {
            Toast.makeText(this, "Please enter a Password", Toast.LENGTH_SHORT).show();
        } else {

            firebaseAuth.signInWithEmailAndPassword(emailstr, passwordstr).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        //startActivity(new Intent(LogIn.this, Home.class));
                        //Toast.makeText(LogIn.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                        checkEmailVerification();
                    } else {
                        Toast.makeText(UserLoginActivity.this, "LogIn Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void checkEmailVerification(){
        FirebaseUser firebaseUser = firebaseAuth.getInstance().getCurrentUser();
        Boolean emailverify = firebaseUser.isEmailVerified();

        if (emailverify){
            finish();
            startActivity(new Intent(this, PharmacyActivity.class));
        }else {
            Toast.makeText(this, "Verify your email",Toast.LENGTH_SHORT).show();
            firebaseAuth.signOut();
        }
    }
}
