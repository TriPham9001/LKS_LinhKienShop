package com.example.lks_linhkienshop.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lks_linhkienshop.Adapter.SearchAdapter;
import com.example.lks_linhkienshop.Model.Search;
import com.example.lks_linhkienshop.R;

import java.util.ArrayList;
import java.util.List;

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
                Intent i =new Intent(SearchActivity.this, MainActivity.class);
                startActivity(i);
//                MainActivity a=new MainActivity();
//                a.hideBotomNav();
            }
        });
        rcvSearch = findViewById(R.id.rcvSearch);
        rcvSearch.setHasFixedSize(true);
        rcvSearch.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rcvSearch.setAdapter(new SearchAdapter(initDataSearch()));


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return (true);
            }
        });


    }
    private List<Search> initDataSearch() {
        itemListSearch = new ArrayList<>();
        itemListSearch.add(new Search(R.drawable.cpu, "Mainboard", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "CPU", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Ram", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Ổ cứng HDD", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Ổ cứng SSD", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "VGA Card", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Sound Card", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Case", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Power", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Fan CPU", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "DVD", "205050"));
        itemListSearch.add(new Search(R.drawable.cpu, "Keo tán nhiệt", "205050"));

        return itemListSearch;
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
