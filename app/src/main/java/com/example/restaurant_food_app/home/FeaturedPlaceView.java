package com.example.restaurant_food_app.home;


import com.example.restaurant_food_app.home.model.Places;

import java.util.List;

public interface FeaturedPlaceView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Places> featuredPlaces);
    void onErrorLoading(String massege);
}
