package com.example.lks_linhkienshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Adapter.ProductAdapter;
import com.example.lks_linhkienshop.Adapter.SearchAdapter;
import com.example.lks_linhkienshop.Model.SanPham;
import com.example.lks_linhkienshop.Model.Search;
import com.example.lks_linhkienshop.R;
import com.example.lks_linhkienshop.retrofit.IRetrofitService;
import com.example.lks_linhkienshop.retrofit.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class SearchActivity extends AppCompatActivity {
    private View imgBack;
    private RecyclerView rcvSearch;
    private List<Search> itemListSearch;
    private SearchView searchView;
    private SearchAdapter searchAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchView = findViewById(R.id.searchView);
        imgBack = findViewById(R.id.imgBack);

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.this.finish();
                //Intent i =new Intent(SearchActivity.this, MainActivity.class);
                //startActivity(i);
//                MainActivity a=new MainActivity();
//                a.hideBotomNav();
            }
        });
        rcvSearch = findViewById(R.id.rcvSearch);
        rcvSearch.setHasFixedSize(true);
        rcvSearch.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));



        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //searchAdapter.getFilter().filter(query);
                search(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //filterList(newText);

                search(newText);
                return (true);
            }
        });


    }
    private void search(String query) {
        IRetrofitService iRetrofitService = RetrofitBuilder.getClinet().create(IRetrofitService.class);
        Search txtSearch=new Search(query);
        Call<List<Search>> call = iRetrofitService.search(txtSearch);
        call.enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, retrofit2.Response<List<Search>> response) {
                if (response.isSuccessful()){

                    rcvSearch.setAdapter(new SearchAdapter(response.body()));
                } else {
                    //do nothing

                }
            }

            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {
                //do nothing
            }
        });
    }


    private void filterList(String text) {
        List<Search> filteredList = new ArrayList<>();
        for (Search search : itemListSearch) {
            if (search.getTenSp().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(search);
            }
        }
        if (filteredList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }
        else {
            searchAdapter.setFilteredList(filteredList);
        }

    }

}
