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

import com.example.lks_linhkienshop.Adapter.CategoryAdapter;
import com.example.lks_linhkienshop.Adapter.ProductAdapter;
import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rcvCatagory,rcvProduct;
    private List<Category> itemListCategory;
    private List<Product> itemListProduct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcvCatagory = view.findViewById(R.id.rcvCategory);
        rcvCatagory.setHasFixedSize(true);
        rcvCatagory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        rcvCatagory.setAdapter(new CategoryAdapter(initDataCategory()));

        rcvProduct = view.findViewById(R.id.rcvProduct);
        rcvProduct.setHasFixedSize(true);
        rcvProduct.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvProduct.setAdapter(new ProductAdapter(initDataProduct()));



        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
        rcvProduct.setLayoutManager(gridLayoutManager);
        rcvProduct.setAdapter(new ProductAdapter(initDataProduct()));


        return view;


    }

    private List<Category> initDataCategory() {
        itemListCategory = new ArrayList<>();
        itemListCategory.add(new Category(R.drawable.cpu,"Mainboard"));
        itemListCategory.add(new Category(R.drawable.cpu,"CPU"));
        itemListCategory.add(new Category(R.drawable.cpu,"Ram"));
        itemListCategory.add(new Category(R.drawable.cpu,"Ổ cứng HDD"));
        itemListCategory.add(new Category(R.drawable.cpu,"Ổ cứng SSD"));
        itemListCategory.add(new Category(R.drawable.cpu,"VGA Card"));
        itemListCategory.add(new Category(R.drawable.cpu,"Sound Card"));
        itemListCategory.add(new Category(R.drawable.cpu,"Case"));
        itemListCategory.add(new Category(R.drawable.cpu,"Power"));
        itemListCategory.add(new Category(R.drawable.cpu,"Fan CPU"));
        itemListCategory.add(new Category(R.drawable.cpu,"DVD"));
        itemListCategory.add(new Category(R.drawable.cpu,"Keo tán nhiệt"));

        return itemListCategory;
    }

    public List<Product> initDataProduct() {
        itemListProduct = new ArrayList<>();
        itemListProduct.add(new Product(R.drawable.cpu,"Mainboard Asus H81M-K","1,390,000","hahahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        itemListProduct.add(new Product(R.drawable.ic_favorite,"CPU Intel Celeron G5905","1,390,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"RAM Desktop Kingmax 4GB DDR4 Bus 2666MHz","590,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"Ổ cứng HDD 2TB Seagate SkyHawk ST2000VX008","1,440,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"Ổ cứng SSD 256GB ADATA SX6000 (ASX6000LNP-256GT-C)","1,090,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"VGA ASUS DUAL-RTX2060S-O8G-EVO-V2","liên hệ","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"Sound card NEWMB N-EXPS8738","liên hệ","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"VGA ASUS DUAL-RTX2060S-O8G-EVO-V2","370,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"Case Jetek Rhino Art - G9323","liên hệ","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"Nguồn Arrow 625W","440,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"DVDRW Transcend TS8XDVDS-K","750,000","hahah"));
        itemListProduct.add(new Product(R.drawable.cpu,"Keo tản nhiệt CoolerMaster MASTERGEL REGULAR","130,000","hahah"));

        return itemListProduct;
    }



}