package com.example.lks_linhkienshop.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.R;

public class SetAccountFragment extends Fragment {
    private ImageView imgAvatar, imgBack;
    private ConstraintLayout ctlChangeAvatar;
    private EditText edUserName, edAddress, edChangeNumber;
    private Button btnChange;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_account, container, false);

        imgBack = view.findViewById(R.id.imgBack);
        imgAvatar = view.findViewById(R.id.imgAvatarChange);
        ctlChangeAvatar = view.findViewById(R.id.ctlChangeAvatar);
        edUserName = view.findViewById(R.id.edChangeUserName);
        edAddress = view.findViewById(R.id.edChangeAddress);
        edChangeNumber = view.findViewById(R.id.edChangeNumber);
        btnChange = view.findViewById(R.id.btnChangeAcc);
        setOnClick(view);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity() ).hideBotomNav();
    }

    public void setOnClick(View view) {
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity() ).showBottomNav();
                Fragment f = new PersonFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.layout_SetAccount, f).commit();
            }
        });
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new PersonFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.layout_SetAccount, f).commit();
            }
        });
    }


}
