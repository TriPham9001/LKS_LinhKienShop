package com.example.lks_linhkienshop.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.Adapter.CategoryAdapter;
import com.example.lks_linhkienshop.Adapter.ProductAdapter;
import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rcvCatagory, rcvProduct;
    private List<Category> itemListCategory;
    private List<Product> itemListProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        rcv(view);

        return view;


    }


    private void rcv(View view) {
        rcvCatagory = view.findViewById(R.id.rcvCategory);
        rcvCatagory.setHasFixedSize(true);
        rcvCatagory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvCatagory.setAdapter(new CategoryAdapter(initDataCategory()));

        rcvProduct = view.findViewById(R.id.rcvProduct);
        rcvProduct.setHasFixedSize(true);
        rcvProduct.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvProduct.setAdapter(new ProductAdapter(initDataProduct()));


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rcvProduct.setLayoutManager(gridLayoutManager);
        rcvProduct.setAdapter(new ProductAdapter(initDataProduct()));

    }

    private List<Category> initDataCategory() {
        itemListCategory = new ArrayList<>();
        itemListCategory.add(new Category(1, "Mainboard"));
        itemListCategory.add(new Category(2, "CPU"));
        itemListCategory.add(new Category(4, "Ram"));
        itemListCategory.add(new Category(5, "Ổ cứng HDD"));
        itemListCategory.add(new Category(6, "Ổ cứng SSD"));
        itemListCategory.add(new Category(7, "VGA Card"));
        itemListCategory.add(new Category(8, "Sound Card"));
        itemListCategory.add(new Category(9, "Case"));
        itemListCategory.add(new Category(10, "Power"));
        itemListCategory.add(new Category(11, "Fan CPU"));
        itemListCategory.add(new Category(12, "DVD"));
        itemListCategory.add(new Category(13, "Keo tán nhiệt"));

        return itemListCategory;
    }


    private List<Product> initDataProduct() {
        itemListProduct = new ArrayList<>();
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad", "Mainboard Asus H81M-K", 1390000, "hahahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",true));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","CPU Intel Celeron G5905",1390000,"hahah",false));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","RAM Desktop Kingmax 4GB DDR4 Bus 2666MHz",524825,"hahah",true));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","Ổ cứng HDD 2TB Seagate SkyHawk ST2000VX008",1440000,"hahah",false));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","Ổ cứng SSD 256GB ADATA SX6000 (ASX6000LNP-256GT-C)",1090000,"hahah",false));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","VGA ASUS DUAL-RTX2060S-O8G-EVO-V2",550000,"hahah",false));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","Sound card NEWMB N-EXPS8738",40000,"hahah",true));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","VGA ASUS DUAL-RTX2060S-O8G-EVO-V2",370000,"hahah",true));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","Case Jetek Rhino Art - G9323",500000,"hahah",false));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","Nguồn Arrow 625W",440000,"hahah",true));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","DVDRW Transcend TS8XDVDS-K",750000,"hahah",true));
        itemListProduct.add(new Product(R.drawable.cpu,1,2,"asdad","Keo tản nhiệt CoolerMaster MASTERGEL REGULAR",130000,"hahah",false));


        return itemListProduct;
    }



}
