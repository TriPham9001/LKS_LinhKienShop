package com.example.lks_linhkienshop.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.DetailActivity;
import com.example.lks_linhkienshop.Activity.ProductByCategoryActivity;
import com.example.lks_linhkienshop.Model.Category;
import com.example.lks_linhkienshop.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewAdapter> {
    private List<Category> mListCategory;
    public CategoryAdapter(List<Category> mListCategory){
        this.mListCategory = mListCategory;
    }
    @NonNull
    @Override
    public CategoryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new CategoryViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewAdapter holder, int position) {
        Category category = mListCategory.get(position);
        if (category == null){
            return;
        }
        holder.txtTenTheLoai.setText(category.getTenTheLoai());

    }

    @Override
    public int getItemCount() {
        if (mListCategory !=null){
            return mListCategory.size();
        }
        return 0;
    }

    public class CategoryViewAdapter extends RecyclerView.ViewHolder{
        private TextView txtTenTheLoai;

        public CategoryViewAdapter(@NonNull View iv) {
            super(iv);
            txtTenTheLoai = iv.findViewById(R.id.txtTenTheLoai);
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    //Log.d("zac", "onClick: "+mListCategory.get(position).getId());
                    Intent i = new Intent(view.getContext(), ProductByCategoryActivity.class);
                    i.putExtra("id", mListCategory.get(position).getId());
                    view.getContext().startActivity(i);
                }
            });
        }



    }
}
