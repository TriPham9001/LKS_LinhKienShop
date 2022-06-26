package com.example.lks_linhkienshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.Adapter.FavoriteAdapter;
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {
    private RecyclerView rcvFavoryte;
    private List<Product> itemListProduct;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_favorite,container,false);

        rcvFavoryte = view.findViewById(R.id.rcvFavorite);
        rcvFavoryte.setHasFixedSize(true);
        rcvFavoryte.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvFavoryte.setAdapter(new FavoriteAdapter(initDataProduct()));

        return view;

    }

    public List<Product> initDataProduct() {
        itemListProduct = new ArrayList<>();
        itemListProduct.add(new Product(1,1,2,"asdad", "Mainboard Asus H81M-K", 1390000, "hahahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",true));
        itemListProduct.add(new Product(1,1,2,"asdad","CPU Intel Celeron G5905",1390000,"hahah",false));
        itemListProduct.add(new Product(1,1,2,"asdad","RAM Desktop Kingmax 4GB DDR4 Bus 2666MHz",524825,"hahah",true));
        itemListProduct.add(new Product(1,1,2,"asdad","Ổ cứng HDD 2TB Seagate SkyHawk ST2000VX008",1440000,"hahah",false));
        itemListProduct.add(new Product(1,1,2,"asdad","Ổ cứng SSD 256GB ADATA SX6000 (ASX6000LNP-256GT-C)",1090000,"hahah",false));
        itemListProduct.add(new Product(1,1,2,"asdad","VGA ASUS DUAL-RTX2060S-O8G-EVO-V2",550000,"hahah",false));
        itemListProduct.add(new Product(1,1,2,"asdad","Sound card NEWMB N-EXPS8738",40000,"hahah",true));
        itemListProduct.add(new Product(1,1,2,"asdad","VGA ASUS DUAL-RTX2060S-O8G-EVO-V2",370000,"hahah",true));
        itemListProduct.add(new Product(1,1,2,"asdad","Case Jetek Rhino Art - G9323",500000,"hahah",false));
        itemListProduct.add(new Product(1,1,2,"asdad","Nguồn Arrow 625W",440000,"hahah",true));
        itemListProduct.add(new Product(1,1,2,"asdad","DVDRW Transcend TS8XDVDS-K",750000,"hahah",true));
        itemListProduct.add(new Product(1,1,2,"asdad","Keo tản nhiệt CoolerMaster MASTERGEL REGULAR",130000,"hahah",false));

        return itemListProduct;
    }


}
