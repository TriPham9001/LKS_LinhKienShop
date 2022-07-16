package com.example.lks_linhkienshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lks_linhkienshop.Activity.LoginActivity;
import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.Model.KhachHang;
import com.example.lks_linhkienshop.R;

public class PersonFragment extends Fragment {
    private ConstraintLayout clShop, clPay, clOder, clHistory, clResertPass, clAccountSett;
    private View btnLogOut;
    private TextView name, diaChi;
    public static KhachHang khachHanginfo;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        clShop = view.findViewById(R.id.layoutShop);
        clPay = view.findViewById(R.id.layoutPay);
        clOder = view.findViewById(R.id.layoutOder);
        clHistory = view.findViewById(R.id.layoutHistory);
        clResertPass = view.findViewById(R.id.layoutResetPassword);
        clAccountSett = view.findViewById(R.id.layoutAccountSettings);
        btnLogOut = view.findViewById(R.id.btnLogOut);
        name = view.findViewById(R.id.txtNamePerson);
        diaChi =view.findViewById(R.id.txtIdEmailPerson);
        name.setText(String.valueOf(khachHanginfo.getTenKH()));
        diaChi.setText(String.valueOf(khachHanginfo.getDiaChi()));

        onClickCl(view);

        return view;
    }

    public void onClickCl(View view) {
        clAccountSett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSetAccountActivity(view);
            }
        });
        clShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToShopFragment(view);
            }
        });
        clPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToPayActivity(view);
            }
        });
        clOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOrderActivity(view);
            }
        });
        clHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToHistoryActivity(view);
            }
        });
        clResertPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToResPass(view);
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin(view);
            }
        });
    }

    public void goToShopFragment(View view) {
        Fragment f = new ShopFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }

    public void goToPayActivity(View view) {
        Fragment f = new PayFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }

    public void goToSetAccountActivity(View view) {
        Fragment f = new SetAccountFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }

    public void goToHistoryActivity(View view) {
        Fragment f = new TransactionHistoryFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }

    public void goToOrderActivity(View view) {
        Fragment f = new OrderFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }
    public void goToResPass(View view) {
        Fragment f = new ChangePasswordFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }
    public void goToLogin(View view) {
        MainActivity.loginstatus = 0;
        Intent i = new Intent(getActivity().getApplication(),MainActivity.class);
        startActivity(i);
    }


}
