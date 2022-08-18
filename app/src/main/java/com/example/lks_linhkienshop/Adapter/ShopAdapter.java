package com.example.lks_linhkienshop.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.lks_linhkienshop.Activity.DetailActivity;
import com.example.lks_linhkienshop.Fragment.ShopFragment;
import com.example.lks_linhkienshop.Model.CTHD;
import com.example.lks_linhkienshop.Model.Image;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.io.InputStream;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewAdapter> {
    private List<CTHD> mListSanPham;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();
    private List<Image> imgs;

    public ShopAdapter(List<CTHD> mListSanPham) {
        this.mListSanPham = mListSanPham;
    }

    @NonNull
    @Override
    public ShopViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill, parent, false);
        return new ShopViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewAdapter holder, int position) {
        CTHD sanPham = mListSanPham.get(position);
        if (sanPham == null) {
            return;
        }
//        holder.imgFavorite.setImageResource(product.getId());
        getImgs(holder, sanPham.getIdSanPham());
        holder.txtNameFavorite.setText(sanPham.getTenSanPham());
        holder.txtPriceFavorite.setText(String.valueOf(sanPham.getDonGia()));
        holder.txtNumber.setText(String.valueOf(sanPham.getSoLuong()));
        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopFragment.gioHang.get(position).setSoLuong(sanPham.getSoLuong()+1);
                holder.txtNumber.setText(String.valueOf(ShopFragment.gioHang.get(position).getSoLuong()));
            }
        });
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShopFragment.gioHang.get(position).getSoLuong()>1)
                {
                    ShopFragment.gioHang.get(position).setSoLuong(sanPham.getSoLuong()-1);
                    holder.txtNumber.setText(String.valueOf(ShopFragment.gioHang.get(position).getSoLuong()));
                }
                else
                {
                    ShopFragment.gioHang.remove(position);
                    notifyDataSetChanged();

                }
            }
        });
        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListSanPham.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListSanPham != null) {
            return mListSanPham.size();
        }
        return 0;
    }
    private void getImgs(@NonNull ShopViewAdapter holder, int idSanPham) {

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        SanPham sp =new SanPham(idSanPham);
        Call<List<Image>> call = iRetrofitService.getimges(sp);
        call.enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, retrofit2.Response<List<Image>> response) {
                if (response.isSuccessful()){
                    //holder.imgProduct.setImageResource(R.drawable.cpu);
                    imgs = response.body();
                    new ShopAdapter.DownloadImageTask(holder.imgFavorite)
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

    public class ShopViewAdapter extends RecyclerView.ViewHolder {
        private RelativeLayout layoutDelete;
        private ImageView imgFavorite;
        private TextView txtNameFavorite, txtPriceFavorite,txtNumber;
        private Button btnAdd,btnRemove;

        public ShopViewAdapter(@NonNull View iv) {
            super(iv);
            layoutDelete = iv.findViewById(R.id.layoutDeleteBill);
            imgFavorite = iv.findViewById(R.id.imgBillProduct);
            txtNameFavorite = iv.findViewById(R.id.txtNameProdBill);
            txtPriceFavorite = iv.findViewById(R.id.txtPriceProdBill);
            txtNumber = iv.findViewById(R.id.txtNumberBill);
            btnAdd = iv.findViewById(R.id.btnAddBill);
            btnRemove = iv.findViewById(R.id.btnRemoveBill);

        }
    }
}
