package com.example.restaurant_food_app;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {
    int[] img;
    LayoutInflater layoutInflater;
    Context context;

    public SliderAdapter(int[] img, SliderImage context) {
        this.img = img;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount(){
        return img.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View myImagerLayout = layoutInflater.inflate(R.layout.element_view_pager_header_shimmer,
                container, false);
        ImageView imageView = myImagerLayout.findViewById(R.id.imageView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            imageView.setImageDrawable(context.getDrawable(img[position]));
        }else{
            imageView.setImageDrawable(container.getResources().getDrawable(img[position]));
        }

        container.addView(myImagerLayout);

        return myImagerLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
}
