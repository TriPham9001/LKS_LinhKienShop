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
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewAdapter> {
    private List<Product> mListProduct;

    public ProductAdapter(List<Product> mListProduct) {
        this.mListProduct = mListProduct;
    }


    @NonNull
    @Override
    public ProductViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewAdapter holder, int position) {
        Product product = mListProduct.get(position);
        if (product == null) {
            return;
        }
        holder.imgProduct.setImageResource(product.getId());
        holder.txtName.setText(product.getTenSanPham());
        holder.txtDonGia.setText(String.valueOf(product.getDonGia()));
    }


    @Override
    public int getItemCount() {
        if (mListProduct != null) {
            return mListProduct.size();
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
            i.putExtra("id",mListProduct.get(position).getId());
            i.putExtra("tenSanPham", mListProduct.get(position).getTenSanPham());
            i.putExtra("donGia", mListProduct.get(position).getDonGia());
            i.putExtra("moTa",mListProduct.get(position).getMoTa());
            view.getContext().startActivity(i);



        }



    }
}
