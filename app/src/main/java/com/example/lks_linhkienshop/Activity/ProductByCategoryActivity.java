package com.example.lks_linhkienshop.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Adapter.ProductAdapter;
import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.Model.Image;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ProductByCategoryActivity extends AppCompatActivity {
    private List<SanPham> itemListSanPham;
    private RecyclerView rcvProduct;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_by_category);
        iv=findViewById(R.id.imglogoHorizontal2);
        rcvProduct = findViewById(R.id.rcvProduct2);
        rcvProduct.setHasFixedSize(true);
        int id = getIntent().getIntExtra("id", 0);
        getSPByCategory(id);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProductByCategoryActivity.this.finish();
            }
        });
    }

    private void getSPByCategory(int idTheLoai) {

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Category cate =new Category(idTheLoai);
        Call<List<SanPham>> call = iRetrofitService.getSPByCategory(cate);
        call.enqueue(new Callback<List<SanPham>>() {
            @Override
            public void onResponse(Call<List<SanPham>> call, retrofit2.Response<List<SanPham>> response) {
                if (response.isSuccessful()){
                    itemListSanPham=response.body();
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(ProductByCategoryActivity.this, 2, GridLayoutManager.VERTICAL, false);
                    rcvProduct.setLayoutManager(gridLayoutManager);
                    rcvProduct.setAdapter(new ProductAdapter(itemListSanPham));

                } else {
                    //do nothing
                }
            }

            @Override
            public void onFailure(Call<List<SanPham>> call, Throwable t) {
                //do nothing
            }
        });
    }
}