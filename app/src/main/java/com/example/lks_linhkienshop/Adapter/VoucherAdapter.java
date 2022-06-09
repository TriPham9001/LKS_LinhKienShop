package com.example.lks_linhkienshop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.Model.Voucher;
import com.example.lks_linhkienshop.R;

import java.util.List;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.VoucherViewAdapter>{
    private List<Voucher> mListVoucher;

    public VoucherAdapter(List<Voucher> mListVoucher){
        this.mListVoucher = mListVoucher;
    }
    @NonNull
    @Override
    public VoucherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_voucher,parent,false);
        return new VoucherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewAdapter holder, int position) {
        Voucher voucher = mListVoucher.get(position);
        if (voucher == null){
            return;
        }
        holder.txtPriceVoucher.setText(voucher.getPrice());
    }

    @Override
    public int getItemCount() {
        if (mListVoucher !=null){
            return mListVoucher.size();
        }
        return 0;
    }

    public class VoucherViewAdapter extends RecyclerView.ViewHolder {
        private TextView txtPriceVoucher;
        public VoucherViewAdapter(@NonNull View itemView) {
            super(itemView);

            txtPriceVoucher = itemView.findViewById(R.id.txtPriceListVoucher);



        }
    }
}
