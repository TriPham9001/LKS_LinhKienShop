package com.example.lks_linhkienshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lks_linhkienshop.Activity.LoginActivity;
import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.R;

public class ChangePasswordFragment extends Fragment {
    private ImageView imgBack;
    private EditText edNewPass, edReNewPass;
    private Button btnResetPass;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        imgBack = view.findViewById(R.id.imgBackResPass);
        edNewPass = view.findViewById(R.id.edChangePassword);
        edReNewPass = view.findViewById(R.id.edChangeRePassword);
        btnResetPass = view.findViewById(R.id.btnChangePassword);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).showBottomNav();
                Fragment f = new  PersonFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.layoutChangePassword, f).commit();
            }
        });

        btnResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginActivity(view);
            }
        });

        return view;

    }

    public void goToLoginActivity(View v)
    {
        Intent intent = new Intent(getActivity().getApplication(), LoginActivity.class);
        startActivity(intent);
    }
}
