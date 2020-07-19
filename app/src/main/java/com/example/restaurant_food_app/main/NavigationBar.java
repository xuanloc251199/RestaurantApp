package com.example.restaurant_food_app.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.restaurant_food_app.R;
import com.example.restaurant_food_app.account.view.AccountFragment;
import com.example.restaurant_food_app.category.view.CategoryFragment;
import com.example.restaurant_food_app.discover.view.DiscoverFragment;
import com.example.restaurant_food_app.home.view.HomeFragment;
import com.example.restaurant_food_app.notification.view.NotificationFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class NavigationBar extends AppCompatActivity {

    //Navigation Bar
    private static final String TAG = NavigationBar.class.getSimpleName();
    ChipNavigationBar bottomNav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_bar);

        bottomNav = findViewById(R.id.bottom_nav);

        if (savedInstanceState == null){
            bottomNav.setItemSelected(R.id.home_nav, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit();
        }

        bottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int id) {
                Fragment fragment = null;
                switch (id){
                    case R.id.home_nav:
                        fragment = new HomeFragment();
                        break;
                    case R.id.category_nav:
                        fragment = new CategoryFragment();
                        break;
//                    case R.id.discover_nav:
//                        fragment = new DiscoverFragment();
//                        break;
                    case R.id.notification_nav:
                        fragment= new NotificationFragment();
                        break;
                    case R.id.account_nav:
                        fragment = new AccountFragment();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container,fragment).commit();
                }else {
                    Log.e(TAG, "Error in creating fragment");
                }
            }
        });

    }

}
