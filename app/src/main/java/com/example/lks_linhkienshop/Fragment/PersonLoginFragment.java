package com.example.lks_linhkienshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.lks_linhkienshop.Activity.LoginActivity;
import com.example.lks_linhkienshop.Activity.SignUpActivity;
import com.example.lks_linhkienshop.R;

public class PersonLoginFragment extends Fragment {
    private Button btnLogin, btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person_login, container, false);

        btnLogin = view.findViewById(R.id.btnSignIn);
        btnRegister = view.findViewById(R.id.btnSignUp);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLogin(view);
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToRegister(view);
            }
        });


        return view;
    }

    public void goToLogin(View view) {
        Intent i = new Intent(getActivity().getApplication(), LoginActivity.class);
        startActivity(i);
    }

    public void goToRegister(View view) {
        Intent i = new Intent(getActivity().getApplication(), SignUpActivity.class);
        startActivity(i);
    }
}