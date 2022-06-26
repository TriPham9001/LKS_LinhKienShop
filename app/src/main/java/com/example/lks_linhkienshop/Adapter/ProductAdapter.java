package com.example.lks_linhkienshop.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.DetailActivity;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewAdapter> {
    private List<SanPham> mListSanPham;

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
        holder.imgProduct.setImageResource(sanPham.getId());
        holder.txtName.setText(sanPham.getTenSanPham());
        holder.txtDonGia.setText(String.valueOf(sanPham.getDonGia()));
    }


    @Override
    public int getItemCount() {
        if (mListSanPham != null) {
            return mListSanPham.size();
        }
        return 0;
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
            i.putExtra("tenSanPham", mListSanPham.get(position).getTenSanPham());
            i.putExtra("donGia", mListSanPham.get(position).getDonGia());
            i.putExtra("moTa", mListSanPham.get(position).getMoTa());
            view.getContext().startActivity(i);



        }



    }
}
