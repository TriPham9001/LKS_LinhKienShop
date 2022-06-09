package com.example.lks_linhkienshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Adapter.VoucherAdapter;
import com.example.lks_linhkienshop.Model.Voucher;
import com.example.lks_linhkienshop.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.List;

public class PayFragment extends Fragment {
    private ConstraintLayout clAddress;
    private TextView txtDeliveryAddress, txtPriceSubtotal, txtPriceDeliveryCharges, txtPriceVoucher, txtPriceTotalBill;
    private Button btnVoucher, btnOder;
    private CheckBox chbMastercard, chbPaymentOnDelivery;
    private BottomSheetDialog dialogVoucher;
    List<Voucher> itemListVoucher;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);

        clAddress = view.findViewById(R.id.clAddress);
        txtDeliveryAddress = view.findViewById(R.id.txtDeliveryAddress);
        txtPriceSubtotal = view.findViewById(R.id.txtPriceSubtotal);
        txtPriceDeliveryCharges = view.findViewById(R.id.txtPriceDeliveryCharges);
        txtPriceVoucher = view.findViewById(R.id.txtPriceVoucher);
        txtPriceTotalBill = view.findViewById(R.id.txtPriceTotalBill);
        btnVoucher = view.findViewById(R.id.btnVoucher);
        btnOder = view.findViewById(R.id.btnOder);
        chbMastercard = view.findViewById(R.id.chbMasterCard);
        chbPaymentOnDelivery = view.findViewById(R.id.chbPaymentOnDelivery);

        btnVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialogVoucher();

            }
        });
        dialogVoucher = new BottomSheetDialog(getActivity());



        return view;
    }

    private void createDialogVoucher() {
        View view = getLayoutInflater().inflate(R.layout.activity_dialog_voucher, null, false);
        Button btnExit = view.findViewById(R.id.btnExit);
        RecyclerView rcvListVoucher = view.findViewById(R.id.rcvListVoucher);


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogVoucher.dismiss();
            }
        });

        dialogVoucher.setContentView(view);
        dialogVoucher.show();


    }




}