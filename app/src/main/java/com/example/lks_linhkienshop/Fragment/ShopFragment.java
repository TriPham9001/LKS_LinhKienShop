package com.example.lks_linhkienshop.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.LoginActivity;
import com.example.lks_linhkienshop.Activity.MainActivity;
import com.example.lks_linhkienshop.Adapter.ShopAdapter;
import com.example.lks_linhkienshop.Model.CTHD;
import com.example.lks_linhkienshop.Model.HoaDon;
import com.example.lks_linhkienshop.Model.KhachHang;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ShopFragment extends Fragment {
    private TextView txtPriceSubtotal,txtPriceTotalBill;
    private Button btnPay;
    public static List<CTHD> gioHang = new ArrayList<>();


    private RecyclerView rcvBill;
    private List<SanPham> itemListSanPham;

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
                if (MainActivity.loginstatus==1)
                {
                    Fragment f = new PayFragment();

                    gioHangU();

                    FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                    fm.replace(R.id.fragmentShop, f).commit();
                }else {
                    Toast.makeText(getContext(),"Bạn chưa đăng nhập",Toast.LENGTH_SHORT).show();
                }

            }
        });
        rcvBill = view.findViewById(R.id.rcvBill);
        rcvBill.setHasFixedSize(true);
        rcvBill.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rcvBill.setAdapter(new ShopAdapter(gioHang));


        return view;
    }

    private void gioHangU() {
        HoaDon hd=new HoaDon(1);
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Call<HoaDon> call = iRetrofitService.taoHoaDon(hd);
        call.enqueue(new Callback<HoaDon>() {
            @Override
            public void onResponse(Call<HoaDon> call, retrofit2.Response<HoaDon> response) {
                if (response.isSuccessful()){
                    HoaDon nhd= new HoaDon();
                    nhd.setId(response.body().getId());
                    Log.d("TAG", "onResponse: "+nhd.getId());

                    Toast.makeText(getContext(), "Successfully!", Toast.LENGTH_SHORT).show();
                } else {

                }
            }

            @Override
            public void onFailure(Call<HoaDon> call, Throwable t) {

            }
        });
    }


/*
    public List<SanPham> initDataProduct() {
        itemListSanPham = new ArrayList<>();
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad", "Mainboard Asus H81M-K", 1390000, "hahahaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",true));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","CPU Intel Celeron G5905",1390000,"hahah",false));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","RAM Desktop Kingmax 4GB DDR4 Bus 2666MHz",524825,"hahah",true));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","Ổ cứng HDD 2TB Seagate SkyHawk ST2000VX008",1440000,"hahah",false));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","Ổ cứng SSD 256GB ADATA SX6000 (ASX6000LNP-256GT-C)",1090000,"hahah",false));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","VGA ASUS DUAL-RTX2060S-O8G-EVO-V2",550000,"hahah",false));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","Sound card NEWMB N-EXPS8738",40000,"hahah",true));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","VGA ASUS DUAL-RTX2060S-O8G-EVO-V2",370000,"hahah",true));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","Case Jetek Rhino Art - G9323",500000,"hahah",false));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","Nguồn Arrow 625W",440000,"hahah",true));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","DVDRW Transcend TS8XDVDS-K",750000,"hahah",true));
        itemListSanPham.add(new SanPham(R.drawable.cpu,1,2,"asdad","Keo tản nhiệt CoolerMaster MASTERGEL REGULAR",130000,"hahah",false));


        return itemListSanPham;
    }*/
}
