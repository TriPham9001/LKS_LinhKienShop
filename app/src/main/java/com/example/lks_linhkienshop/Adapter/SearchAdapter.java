package com.example.lks_linhkienshop.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Model.Search;
import com.example.lks_linhkienshop.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewAdapter> implements Filterable {
    private List<Search> mListSearch;
    private List<Search> mListSearchOld;


    public SearchAdapter(List<Search> mListSearch) {
        this.mListSearch = mListSearch;
        this.mListSearchOld = mListSearch;
    }

    public void setFilteredList(List<Search> filteredList) {
        this.mListSearch = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search, parent, false);
        return new SearchViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewAdapter holder, int position) {
        Search search = mListSearch.get(position);
        if (search == null) {
            return;
        }
        holder.imgSearch.setImageResource(search.getImage());
        holder.txtNameSearch.setText(search.getTenSp());
        holder.txtPriceSearch.setText(search.getGiaSp());
    }

    @Override
    public int getItemCount() {
        if (mListSearch != null) {
            return mListSearch.size();
        }
        return 0;
    }


    public class SearchViewAdapter extends RecyclerView.ViewHolder {
        private CircleImageView imgSearch;
        private TextView txtNameSearch, txtPriceSearch;

        public SearchViewAdapter(@NonNull View iv) {
            super(iv);
            imgSearch = iv.findViewById(R.id.imgSearch);
            txtNameSearch = iv.findViewById(R.id.txtNameSearch);
            txtPriceSearch = iv.findViewById(R.id.txtPriceSearch);
        }

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()) {
                    mListSearch = mListSearchOld;
                } else {
                    List<Search> list = new ArrayList<>();
                    for (Search search : mListSearchOld) {
                        if (search.getTenSp().toLowerCase().contains(strSearch.toLowerCase())) {
                            list.add(search);
                        }
                    }
                    mListSearch = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListSearch;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {
                mListSearch = (List<Search>) results.values;
                notifyDataSetChanged();
            }
        };
    }

}
