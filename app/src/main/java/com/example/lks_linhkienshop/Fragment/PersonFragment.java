package com.example.lks_linhkienshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lks_linhkienshop.Activity.OrderActivity;
import com.example.lks_linhkienshop.Activity.PayActivity;
import com.example.lks_linhkienshop.Activity.TransactionHistoryActivity;
import com.example.lks_linhkienshop.R;

public class PersonFragment extends Fragment {
    private ConstraintLayout clShop, clPay, clOder, clHistory, clResertPass, clAccountSett;
    private View btnLogOut;

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


        onClickCl(view);

        return view;
    }

    public void onClickCl(View view) {
        clShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoShopFragment(view);
            }
        });
        clPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoPayActivity(view);
            }
        });
        clOder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoOrderActivity(view);
            }
        });
        clHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHistoryActivity(view);
            }
        });
    }

    public void gotoShopFragment(View view) {
        Fragment f = new ShopFragment();
        FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.fagContainer, f).commit();
    }

    public void gotoPayActivity(View view) {
        Intent i = new Intent(getActivity(), PayActivity.class);
        startActivity(i);
    }

    public void gotoHistoryActivity(View view) {
        Intent i = new Intent(getActivity(), TransactionHistoryActivity.class);
        startActivity(i);
    }

    public void gotoOrderActivity(View view) {
        Intent i = new Intent(getActivity(), OrderActivity.class);
        startActivity(i);
    }


}
