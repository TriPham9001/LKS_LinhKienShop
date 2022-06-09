package com.example.lks_linhkienshop.Dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Adapter.ShopAdapter;
import com.example.lks_linhkienshop.Adapter.VoucherAdapter;
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.Model.Voucher;
import com.example.lks_linhkienshop.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class DialogVoucher extends Fragment {

    private RecyclerView rcvVoucher;
    private List<Voucher> itemListVoucher;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dialog_voucher,container,false);
        rcvVoucher = view.findViewById(R.id.rcvListVoucher);
        rcvVoucher.setHasFixedSize(true);
        rcvVoucher.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvVoucher.setAdapter(new VoucherAdapter(initDataVoucher()));
        return view;
    }

    private List<Voucher> initDataVoucher() {
        itemListVoucher.add(new Voucher("30000"));
        itemListVoucher.add(new Voucher("30000"));
        itemListVoucher.add(new Voucher("30000"));
        itemListVoucher.add(new Voucher("30000"));
        itemListVoucher.add(new Voucher("30000"));
        itemListVoucher.add(new Voucher("30000"));

        return itemListVoucher;

    }

}