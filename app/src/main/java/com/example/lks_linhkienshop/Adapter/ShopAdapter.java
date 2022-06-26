package com.example.lks_linhkienshop.Adapter;

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
import com.example.lks_linhkienshop.Model.Product;
import com.example.lks_linhkienshop.R;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewAdapter> {
    private List<Product> mListProduct;
    private ViewBinderHelper viewBinderHelper = new ViewBinderHelper();

    public ShopAdapter(List<Product> mListProduct) {
        this.mListProduct = mListProduct;
    }

    @NonNull
    @Override
    public ShopViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill, parent, false);
        return new ShopViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewAdapter holder, int position) {
        Product product = mListProduct.get(position);
        if (product == null) {
            return;
        }
//        holder.imgFavorite.setImageResource(product.getId());
        holder.txtNameFavorite.setText(product.getTenSanPham());
        holder.txtPriceFavorite.setText(String.valueOf(product.getDonGia()));

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
