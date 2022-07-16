package com.example.lks_linhkienshop.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.DetailActivity;
import com.example.lks_linhkienshop.Model.Image;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewAdapter> {
    private List<SanPham> mListSanPham;
    private List<Image> mListImg;

    public ProductAdapter(List<SanPham> mListSanPham) {
        this.mListSanPham = mListSanPham;
    }


    @NonNull
    @Override
    public ProductViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);

        return new ProductViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewAdapter holder, int position) {
        SanPham sanPham = mListSanPham.get(position);
        if (sanPham == null) {
            return;
        }
        getImgs(holder, position, sanPham.getId());
        //holder.imgProduct.setImageResource(R.drawable.cpu);
        holder.txtName.setText(sanPham.getTenSP());
        holder.txtDonGia.setText(String.valueOf(sanPham.getDonGia()));
    }


    @Override
    public int getItemCount() {
        if (mListSanPham != null) {
            return mListSanPham.size();
        }
        return 0;
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
    private void getImgs(@NonNull ProductViewAdapter holder, int position, int idSanPham) {

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        SanPham sp =new SanPham(idSanPham);
        Call<List<Image>> call = iRetrofitService.getimges(sp);
        call.enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, retrofit2.Response<List<Image>> response) {
                if (response.isSuccessful()){
                    //holder.imgProduct.setImageResource(R.drawable.cpu);
                    new DownloadImageTask(holder.imgProduct)
                            .execute(response.body().get(0).getImgUrl());
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

    public class ProductViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgProduct;
        private TextView txtName, txtDonGia, txtMoTa;

        public ProductViewAdapter(@NonNull View iv) {
            super(iv);
            imgProduct = iv.findViewById(R.id.imgProduct);
            txtName = iv.findViewById(R.id.txtNameProduct);
            txtDonGia = iv.findViewById(R.id.txtDonGia);
            txtMoTa = iv.findViewById(R.id.txtMoTa);
            iv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent i = new Intent(view.getContext(), DetailActivity.class);
            i.putExtra("id", mListSanPham.get(position).getId());
            i.putExtra("tenSanPham", mListSanPham.get(position).getTenSP());
            i.putExtra("donGia", mListSanPham.get(position).getDonGia());
            i.putExtra("moTa", mListSanPham.get(position).getMoTa());
            view.getContext().startActivity(i);



        }



    }
}
