package com.example.lks_linhkienshop.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lks_linhkienshop.Model.KhachHang;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private EditText edSoDt, edPasswprd;
    private String soDT, password, matKhau;
    private Button btnSignIn;
    private TextView txtForgetPassword, txtSignUp;
    private String URL = "http://192.168.1.93:8080/LKS_PHP/controllers/nhan_vien_controller.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        soDT = password = matKhau = "";
        edSoDt = findViewById(R.id.edEmail);
        edPasswprd = findViewById(R.id.edPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtSignUp = findViewById(R.id.txtSignUp);
/*
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(view);
            }
        });*/
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edSoDt.getText().toString().trim();
                String password = edPasswprd.getText().toString().trim();

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)){
                    loginU();
                } else {
                    Toast.makeText(LoginActivity.this, "Khong duoc de trong!", Toast.LENGTH_SHORT).show();
                }
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
/*
    public void login(View view){
        soDT = edSoDt.getText().toString().trim();
        password = edPasswprd.getText().toString().trim();
        if(!soDT.equals("") && !password.equals("")){
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("Success")) {
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    } else if (response.equals("faile")) {
                        Toast.makeText(LoginActivity.this, "Invalid Login Id/Passwprd", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this,error.toString().trim(),Toast.LENGTH_SHORT).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String > data = new HashMap<>();
                    data.put("soDT",soDT);
                    data.put("matKhau",password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }else {
            Toast.makeText(this, "Fields can not be empty!", Toast.LENGTH_SHORT).show();
        }

    }*/

    private void loginU() {

        soDT = edSoDt.getText().toString().trim();
        matKhau = edPasswprd.getText().toString().trim();
        KhachHang kh=new KhachHang(soDT,matKhau);
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<KhachHang> call = iRetrofitService.login(kh);
        call.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, retrofit2.Response<KhachHang> response) {
                if (response.body().getMatKhau().equals(matKhau)){

                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);



                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Sai TK or MK", Toast.LENGTH_SHORT).show();


                }
                Log.d("TAG", "onResponse: "+response.body().getMatKhau());
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                Log.d("TAGE", "onFailure: "+t.toString());
                Toast.makeText(LoginActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}