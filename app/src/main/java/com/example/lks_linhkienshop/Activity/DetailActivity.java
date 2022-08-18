package com.example.lks_linhkienshop.Activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lks_linhkienshop.Fragment.ShopFragment;
import com.example.lks_linhkienshop.Model.CTHD;
import com.example.lks_linhkienshop.Model.Image;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class DetailActivity extends AppCompatActivity {
    private ConstraintLayout clBeforeImg, clNextImg;
    private TextView txtName, txtPrice, txtDescribe,txtImgPresent,txtImgTotal;
    private ImageView imgProduct;
    private Button btnAddToCard;
    private List<Image> imgs = null;
    int imgPosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtName = findViewById(R.id.txtDetailName);
        txtPrice = findViewById(R.id.txtDetailPrice);
        txtDescribe = findViewById(R.id.txtDescribeDetail);
        txtImgPresent = findViewById(R.id.txtImgPresent);//vị trí ảnh hiện tại đang ở
        txtImgTotal = findViewById(R.id.txtImgTotal);//Tổng số ảnh
        imgProduct = findViewById(R.id.imgDetail);
        btnAddToCard = findViewById(R.id.btnAddToCard);
        clBeforeImg = findViewById(R.id.clBeforeImg);//quay lại ảnh
        clNextImg = findViewById(R.id.clNextImg);//qua ảnh mới



        int id = getIntent().getIntExtra("id", 0);
        String tenSanPham = getIntent().getStringExtra("tenSanPham");
        float donGiaf =getIntent().getFloatExtra("donGia",0);
        String donGia = String.valueOf(donGiaf);
        String moTa = getIntent().getStringExtra("moTa");
        getImgs(id);
        //imgProduct.setImageResource(img);
        txtName.setText(tenSanPham);
        txtPrice.setText(String.valueOf(donGia));
        txtDescribe.setText(moTa);

        clNextImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imgPosition<imgs.size()-1)
                {
                    new DetailActivity.DownloadImageTask(imgProduct).execute(imgs.get(imgPosition+1).getImgUrl());
                    imgPosition += 1;
                    txtImgPresent.setText(String.valueOf(imgPosition+1));
                }
            }
        });
        clBeforeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imgPosition>0)
                {
                    new DetailActivity.DownloadImageTask(imgProduct).execute(imgs.get(imgPosition-1).getImgUrl());
                    imgPosition -= 1;
                    txtImgPresent.setText(String.valueOf(imgPosition+1));
                }
            }
        });

        btnAddToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CTHD sp=new CTHD(id, 1, tenSanPham, donGiaf);
                if (ShopFragment.gioHang.size()==0)
                {
                    ShopFragment.gioHang.add(sp);
                    Toast.makeText(DetailActivity.this, "Đã thêm "+sp.getTenSanPham(), Toast.LENGTH_SHORT).show();
                    DetailActivity.this.finish();
//                    Fragment f = new ShopFragment();
//                    FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//                    fm.replace(R.id.detailConstraintLayout, f).commit();
                }
                else
                {
                    for (int i=0;i<=ShopFragment.gioHang.size();i++)
                    {
                        if (ShopFragment.gioHang.get(i).getIdSanPham()!=sp.getIdSanPham())
                        {
                            if (i+1==ShopFragment.gioHang.size())
                            {
                                ShopFragment.gioHang.add(sp);
                                Toast.makeText(DetailActivity.this, "Đã thêm "+sp.getTenSanPham(), Toast.LENGTH_SHORT).show();
                                DetailActivity.this.finish();
//                                Fragment f = new ShopFragment();
//                                FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
//                                fm.replace(R.id.detailConstraintLayout, f).commit();
                                break;
                            }

                        }
                        else
                        {
                            ShopFragment.gioHang.get(i).setSoLuong(ShopFragment.gioHang.get(i).getSoLuong()+1);
                            Toast.makeText(DetailActivity.this, "Đã thêm "+sp.getTenSanPham(), Toast.LENGTH_SHORT).show();
                            DetailActivity.this.finish();
                            break;
                        }
                    }
                }

            }
        });
    }

    private void getImgs(int idSanPham) {

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        SanPham sp =new SanPham(idSanPham);
        Call<List<Image>> call = iRetrofitService.getimges(sp);
        call.enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, retrofit2.Response<List<Image>> response) {
                if (response.isSuccessful()){
                    //holder.imgProduct.setImageResource(R.drawable.cpu);
                    imgs = response.body();
                    new DetailActivity.DownloadImageTask(imgProduct)
                            .execute(response.body().get(0).getImgUrl());
                    txtImgTotal.setText(String.valueOf(imgs.size()));
                    txtImgPresent.setText(String.valueOf(1));
                    imgPosition = 0;

                } else {
                    //do nothing
                }
            }

            @Override
            public void onFailure(Call<List<Image>> call, Throwable t) {
                //do nothing
            }
        });
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }



}