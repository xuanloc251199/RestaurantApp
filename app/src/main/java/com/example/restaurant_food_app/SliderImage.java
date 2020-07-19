package com.example.restaurant_food_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class SliderImage extends AppCompatActivity {

    ViewPager viewPager;

    int img[] = {R.drawable.bun_rieu, R.drawable.bun_kho, R.drawable.banh_cuon};

    int currantPageCunter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);
        viewPager = findViewById(R.id.viewPagerHeader);

        viewPager.setAdapter(new SliderAdapter(img, SliderImage.this));
        final Handler handler = new Handler();
        final Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currantPageCunter == img.length){
                    currantPageCunter = 0;
                }
                viewPager.setCurrentItem(currantPageCunter++, true);
            }
        };

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 4000, 4000);
    }
}
