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


import com.example.lks_linhkienshop.Fragment.PersonFragment;
import com.example.lks_linhkienshop.Model.KhachHang;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;



import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {
    private EditText edSoDt, edPasswprd;
    private String soDT, password, matKhau;
    private Button btnSignIn;
    private TextView txtForgetPassword, txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MainActivity.loginstatus=0;
        soDT = password = matKhau = "";
        edSoDt = findViewById(R.id.edPhone);
        edPasswprd = findViewById(R.id.edPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtSignUp = findViewById(R.id.txtSignUp);

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

    private void loginU() {
        soDT = edSoDt.getText().toString().trim();
        matKhau = edPasswprd.getText().toString().trim();
        KhachHang kh=new KhachHang(soDT,matKhau);
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<KhachHang> call = iRetrofitService.login(kh);
        call.enqueue(new Callback<KhachHang>() {
            @Override
            public void onResponse(Call<KhachHang> call, retrofit2.Response<KhachHang> response) {
                if (response.isSuccessful()){
                    Log.d("TAG", "onResponse: "+response.body());
                    Log.d("TAG2", "onResponse: "+response.body().getId());
                    MainActivity.loginstatus = 1;
                    Log.d("TAG3", "onResponse: "+MainActivity.loginstatus);
                    PersonFragment.khachHanginfo =new KhachHang();
                    PersonFragment.khachHanginfo.setId(response.body().getId());
                    PersonFragment.khachHanginfo.setTenKH(response.body().getTenKH());
                    PersonFragment.khachHanginfo.setDiaChi(response.body().getDiaChi());
                    PersonFragment.khachHanginfo.setMatKhau(response.body().getMatKhau());
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Sai TK or MK", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KhachHang> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Sai TK or MK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}