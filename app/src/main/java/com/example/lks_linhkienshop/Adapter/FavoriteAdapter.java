package com.example.lks_linhkienshop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.FavoriteViewAdapter> {
    private List<Product> mListProduct;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public FavoriteAdapter(List<Product> mListProduct) {
        this.mListProduct = mListProduct;
    }

    @NonNull
    @Override
    public FavoriteViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product_favorite, parent, false);
        return new FavoriteViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteViewAdapter holder, int position) {
        Product product = mListProduct.get(position);
        if (product == null) {
            return;
        }
        holder.txtNameFavorite.setText(product.getTenSanPham());
        holder.txtPriceFavorite.setText((String.valueOf(product.getDonGia())));

        holder.layoutDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListProduct.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListProduct != null) {
            return mListProduct.size();
        }
        return 0;
    }

    public class FavoriteViewAdapter extends RecyclerView.ViewHolder {
        private RelativeLayout layoutDelete;
        private ImageView imgFavorite;
        private TextView txtNameFavorite, txtPriceFavorite;

        public FavoriteViewAdapter(@NonNull View iv) {
            super(iv);
            layoutDelete = iv.findViewById(R.id.layoutDelete);
            imgFavorite = iv.findViewById(R.id.imgFavoriteProduct);
            txtNameFavorite = iv.findViewById(R.id.txtNameFavorite);
            txtPriceFavorite = iv.findViewById(R.id.txtPriceFavorite);


        }
    }
}
