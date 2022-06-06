package com.example.lks_linhkienshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lks_linhkienshop.R;

public class LoginActivity extends AppCompatActivity {
    private EditText edEmail, edPasswprd;
    private Button btnSignIn;
    private TextView txtForgetPassword,txtSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edEmail = findViewById(R.id.edEmail);
        edPasswprd = findViewById(R.id.edPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtSignUp =  findViewById(R.id.txtSignUp);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
                Toast.makeText(LoginActivity.this, "Wellcome to Linh Kien Shop", Toast.LENGTH_LONG).show();
            }
        });
        txtSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(i);
                Toast.makeText(LoginActivity.this, "Wellcome to Sign Up", Toast.LENGTH_LONG).show();
            }
        });


    }
}