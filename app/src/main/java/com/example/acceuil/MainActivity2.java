package com.example.acceuil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);



        bottomNavigationView = findViewById(R.id.bottomNavView);
        frameLayout = findViewById(R.id.framelayout);

        ImageButton addButton = findViewById(R.id.add);
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) addButton.getLayoutParams();
        params.bottomMargin = getResources().getDimensionPixelSize(R.dimen.add_button_bottom_margin);
        addButton.setLayoutParams(params);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lorsque le bouton "add" est cliqué, démarrer l'activité activity_form
                Intent intent = new Intent(MainActivity2.this, FormActivity.class);
                startActivity(intent);
            }
        });


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    loadFragment(new HomeFragment(), false);
                } else if (itemId == R.id.service) {
                    loadFragment(new ServiceFragment(), false);
                } else if (itemId == R.id.profile) {
                    loadFragment(new ProfileFragment(), false);
                } else {
                    loadFragment(new AboutFragment(), false);
                }
                return true;
            }
        });

        // Chargement initial du fragment Home
        loadFragment(new HomeFragment(), true);
    }

    private void loadFragment(Fragment fragment, boolean isAppInitialized) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if (isAppInitialized) {
            fragmentTransaction.add(R.id.framelayout, fragment);
        } else {
            fragmentTransaction.replace(R.id.framelayout, fragment);
        }

        fragmentTransaction.commit();
    }
}






