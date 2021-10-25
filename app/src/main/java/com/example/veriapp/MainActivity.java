package com.example.veriapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    calendarioFragment calendarioFragment=new calendarioFragment();
    ColibriFragment colibriFragment=new ColibriFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragmentblank,calendarioFragment)
                .show(calendarioFragment)
                .commit();
        fragmentManager
                .beginTransaction()
                .add(R.id.fragmentblank,colibriFragment)
                .show(colibriFragment)
                .commit();


        BottomNavigationView btnNav = findViewById(R.id.navigation);
        btnNav.setOnNavigationItemSelectedListener(navListener);



        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentblank,new calendarioFragment()).commit();


    }

   private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
           BottomNavigationView.OnNavigationItemSelectedListener() {
               @Override
               public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                   Fragment selectedFragment=null;
                   switch (item.getItemId()) {
                       case R.id.cale:
                           selectedFragment = new calendarioFragment();
                           break;
                       case R.id.colibri:
                           selectedFragment = new ColibriFragment();
                           break;
                       case R.id.doc:
                           selectedFragment = new DocFragment();
                           break;
                       case R.id.cof:
                           selectedFragment = new ConfigFragment();
                           break;
                   }
                   getSupportFragmentManager().beginTransaction()
                           .replace(R.id.fragmentblank,selectedFragment).commit();
                   return true;


               }
           };

}