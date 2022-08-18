package com.example.lks_linhkienshop.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Activity.DetailActivity;
import com.example.lks_linhkienshop.Model.Image;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.Model.Search;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;

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
        getImgs(holder, position, search.getId());
        //holder.imgSearch.setImageResource(search.getImage());
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
    private void getImgs(@NonNull SearchAdapter.SearchViewAdapter holder, int position, int idSanPham) {

        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        SanPham sp =new SanPham(idSanPham);
        Call<List<Image>> call = iRetrofitService.getimges(sp);
        call.enqueue(new Callback<List<Image>>() {
            @Override
            public void onResponse(Call<List<Image>> call, retrofit2.Response<List<Image>> response) {
                if (response.isSuccessful()){
                    //holder.imgProduct.setImageResource(R.drawable.cpu);
                    new SearchAdapter.DownloadImageTask(holder.imgSearch)
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


    public class SearchViewAdapter extends RecyclerView.ViewHolder implements View.OnClickListener {
        private CircleImageView imgSearch;
        private TextView txtNameSearch, txtPriceSearch;

        public SearchViewAdapter(@NonNull View iv) {
            super(iv);
            imgSearch = iv.findViewById(R.id.imgSearch);
            txtNameSearch = iv.findViewById(R.id.txtNameSearch);
            txtPriceSearch = iv.findViewById(R.id.txtPriceSearch);
            iv.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Intent i = new Intent(view.getContext(), DetailActivity.class);
            i.putExtra("id", mListSearch.get(position).getId());
            i.putExtra("tenSanPham", mListSearch.get(position).getTenSp());
            i.putExtra("donGia", mListSearch.get(position).getDonGia());
            i.putExtra("moTa", mListSearch.get(position).getMoTa());
            view.getContext().startActivity(i);
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
