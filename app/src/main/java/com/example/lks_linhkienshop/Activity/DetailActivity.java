package com.example.lks_linhkienshop.Activity;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lks_linhkienshop.Fragment.ShopFragment;
import com.example.lks_linhkienshop.R;


public class DetailActivity extends AppCompatActivity {
    private TextView txtName, txtPrice, txtDescribe;
    private ImageView imgProduct;
    private Button btnAddToCard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtName = findViewById(R.id.txtDetailName);
        imgProduct = findViewById(R.id.imgDetail);
        txtPrice = findViewById(R.id.txtDetailPrice);
        txtDescribe = findViewById(R.id.txtDescribeDetail);
        btnAddToCard = findViewById(R.id.btnAddToCard);

        btnAddToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new ShopFragment();
                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.detailConstraintLayout, f).commit();

            }
        });
        int img = getIntent().getIntExtra("img", 0);
        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String describe = getIntent().getStringExtra("describe");

        imgProduct.setImageResource(img);
        txtName.setText(name);
        txtPrice.setText(price);
        txtDescribe.setText(describe);
    }




}