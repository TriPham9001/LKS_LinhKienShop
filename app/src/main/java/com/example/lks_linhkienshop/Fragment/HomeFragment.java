package com.example.lks_linhkienshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.LoginActivity;
import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.Activity.SearchActivity;
import com.example.lks_linhkienshop.Adapter.CategoryAdapter;
import com.example.lks_linhkienshop.Adapter.ProductAdapter;
import com.example.lks_linhkienshop.Adapter.SearchAdapter;
import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.Model.KhachHang;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeFragment extends Fragment {
    private TextView txtSearch;
    private RecyclerView rcvCatagory, rcvProduct;
    private List<Category> itemListCategory;
    private List<SanPham> itemListSanPham;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rcv(view);
        txtSearch = view.findViewById(R.id.txtSearch);
        mIntent(view);
        return view;


    }

    public void mIntent(View view) {
        txtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Fragment f = new SearchFragment();
//                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
//                fm.replace(R.id.fagContainer, f).commit();
                Intent i =new Intent(getActivity().getApplication(), SearchActivity.class);
                startActivity(i);
            }
        });
    }

    private void rcv(View view) {
        rcvCatagory = view.findViewById(R.id.rcvCategory);
        rcvCatagory.setHasFixedSize(true);
        rcvProduct = view.findViewById(R.id.rcvProduct);
        rcvProduct.setHasFixedSize(true);
        getCategory();
        getSPHotU();

    }

    private void getSPHotU() {
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<List<SanPham>> call = iRetrofitService.sanphamhot();
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, retrofit2.Response<List<SanPham>> response) {
                if (response.isSuccessful()){
                    itemListSanPham=response.body();
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
                    rcvProduct.setLayoutManager(gridLayoutManager);
                    rcvProduct.setAdapter(new ProductAdapter(itemListSanPham));
                } else {
                    Toast.makeText(getContext(), "Sai TK or MK", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                Toast.makeText(getContext(), "Sai TK or MK", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getCategory() {
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<List<Category>> call = iRetrofitService.getCategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, retrofit2.Response<List<Category>> response) {
                if (response.isSuccessful()){
                    itemListCategory=response.body();
                    rcvCatagory.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    rcvCatagory.setAdapter(new CategoryAdapter(itemListCategory));
                } else {
                    Toast.makeText(getContext(), "Sai TK or MK", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Toast.makeText(getContext(), "Sai TK or MK", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
