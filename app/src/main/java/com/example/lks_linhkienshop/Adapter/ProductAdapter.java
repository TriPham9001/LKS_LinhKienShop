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
        holder.imgProduct.setImageResource(product.getImage());
        holder.txtName.setText(product.getName());
        holder.txtPrince.setText(product.getPrice());
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
        private TextView txtName, txtPrince, txtDescribe;

        public ProductViewAdapter(@NonNull View iv) {
            super(iv);
            imgProduct = iv.findViewById(R.id.imgProduct);
            txtName = iv.findViewById(R.id.txtNameProduct);
            txtPrince = iv.findViewById(R.id.txtPrinceProduct);
            txtDescribe = iv.findViewById(R.id.txtDescribeProduct);
            iv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent i = new Intent(view.getContext(), DetailActivity.class);
            i.putExtra("name", mListProduct.get(position).getName());
            i.putExtra("img", mListProduct.get(position).getImage());
            i.putExtra("price", mListProduct.get(position).getPrice());
            i.putExtra("describe",mListProduct.get(position).getDescribe());
            view.getContext().startActivity(i);



        }



    }
}
