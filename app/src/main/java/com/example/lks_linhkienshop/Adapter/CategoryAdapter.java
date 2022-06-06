package com.example.lks_linhkienshop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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
        holder.imgCategory.setImageResource(category.getImage());
        holder.txtName.setText(category.getName());

    }

    @Override
    public int getItemCount() {
        if (mListCategory !=null){
            return mListCategory.size();
        }
        return 0;
    }

    public class CategoryViewAdapter extends RecyclerView.ViewHolder{
        private CircleImageView imgCategory;
        private TextView txtName;

        public CategoryViewAdapter(@NonNull View iv) {
            super(iv);
            imgCategory = iv.findViewById(R.id.imgCategory);
            txtName = iv.findViewById(R.id.txtName);
        }

    }
}
