package com.example.lks_linhkienshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.Adapter.FavoriteAdapter;
import com.example.lks_linhkienshop.Adapter.ShopAdapter;
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.ArrayList;
import java.util.List;

public class ShopFragment extends Fragment {
    private TextView txtPriceSubtotal,txtPriceTotalBill;
    private Button btnPay;


    private RecyclerView rcvBill;
    private List<Product> itemListProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        txtPriceSubtotal = view.findViewById(R.id.txtPriceSubtotal);
        txtPriceTotalBill = view.findViewById(R.id.txtPriceTotalBill);
        btnPay = view.findViewById(R.id.btnPay);

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).hideBotomNav();
                Fragment f = new PayFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.fragmentShop, f).commit();
            }
        });
        rcvBill = view.findViewById(R.id.rcvBill);
        rcvBill.setHasFixedSize(true);
        rcvBill.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvBill.setAdapter(new ShopAdapter(initDataProduct()));


        return view;
    }



    public List<Product> initDataProduct() {
        itemListProduct = new ArrayList<>();
        itemListProduct.add(new Product(R.drawable.cpu, "Mainboard Asus H81M-K", "1,390,000", "hahahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        itemListProduct.add(new Product(R.drawable.ic_favorite, "CPU Intel Celeron G5905", "1,390,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "RAM Desktop Kingmax 4GB DDR4 Bus 2666MHz", "590,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "Ổ cứng HDD 2TB Seagate SkyHawk ST2000VX008", "1,440,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "Ổ cứng SSD 256GB ADATA SX6000 (ASX6000LNP-256GT-C)", "1,090,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "VGA ASUS DUAL-RTX2060S-O8G-EVO-V2", "liên hệ", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "Sound card NEWMB N-EXPS8738", "liên hệ", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "VGA ASUS DUAL-RTX2060S-O8G-EVO-V2", "370,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "Case Jetek Rhino Art - G9323", "liên hệ", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "Nguồn Arrow 625W", "440,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "DVDRW Transcend TS8XDVDS-K", "750,000", "hahah"));
        itemListProduct.add(new Product(R.drawable.cpu, "Keo tản nhiệt CoolerMaster MASTERGEL REGULAR", "130,000", "hahah"));

        return itemListProduct;
    }
}
