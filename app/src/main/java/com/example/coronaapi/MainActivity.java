package com.example.coronaapi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.coronaapi.fragment.CountriesFragment;
import com.example.coronaapi.fragment.WorldFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new WorldFragment());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.world_menu:
                loadFragment(new WorldFragment());
                break;

            case R.id.countries_menu:
                loadFragment(new CountriesFragment());
                break;
        }
        return true;
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if (selectedFragment != null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container,selectedFragment)
                    .commit();
            return true;
        }
        else
        {
            return false;
        }

    }
}