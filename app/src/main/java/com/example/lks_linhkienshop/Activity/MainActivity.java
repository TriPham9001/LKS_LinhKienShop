package com.example.lks_linhkienshop.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.lks_linhkienshop.Fragment.FavoriteFragment;
import com.example.lks_linhkienshop.Fragment.HomeFragment;
import com.example.lks_linhkienshop.Fragment.PersonFragment;
import com.example.lks_linhkienshop.Fragment.PersonLoginFragment;
import com.example.lks_linhkienshop.Fragment.ShopFragment;
import com.example.lks_linhkienshop.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        botNav = findViewById(R.id.botNavMenu);
        botNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fagContainer,
                new HomeFragment()).commit();


    }

    public void hideBotomNav() {
        botNav.setVisibility(View.GONE);
    }

    public void showBottomNav() {
        botNav.setVisibility(View.VISIBLE);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selFragment = new HomeFragment();
                            break;
                        case R.id.nav_shop:
                            selFragment = new ShopFragment();
                            break;
                        case R.id.nav_favorite:
                            selFragment = new FavoriteFragment();
                            break;
                        case R.id.nav_person:
                            selFragment = new PersonLoginFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fagContainer, selFragment).commit();
                    return true;
                }
            };

}