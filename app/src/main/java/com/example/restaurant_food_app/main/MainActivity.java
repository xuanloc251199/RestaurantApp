package com.example.restaurant_food_app.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.restaurant_food_app.R;

public class MainActivity extends AppCompatActivity {


    Handler handler;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        img.animate().alpha(4000).setDuration(0);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent dsp  = new Intent(MainActivity.this, NavigationBar.class);
                startActivity(dsp);
                finish();
            }
        },2000);
    }
}
