package com.example.restaurant_food_app.home.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_food_app.R;

public class PlaceByCategoryAdapter {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImagePlace;
        TextView mTitlePlace, mDesPlace;
        CardView mCardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mImagePlace = itemView.findViewById(R.id.img_place_id);
            mTitlePlace = itemView.findViewById(R.id.name_place_id);
            mDesPlace = itemView.findViewById(R.id.address_place_id);
            mCardView = itemView.findViewById(R.id.cardViewPlace_id);
        }
    }
}
