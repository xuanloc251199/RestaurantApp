//package com.example.restaurant_food_app.home.view;
//
//import androidx.annotation.NonNull;
//
//import com.example.restaurant_food_app.home.Utils;
//import com.example.restaurant_food_app.home.api.HomeView;
//import com.example.restaurant_food_app.category.model.Category;
//import com.example.restaurant_food_app.home.model.Places;
//
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//
//public class HomePresenter {
//    private HomeView homeView;
//
//    public HomePresenter(HomeView homeView){
//        this.homeView = homeView;
//    }
//
//    void getPlaces(){
//
//        homeView.showLoading();
//        Call<Places> placesCall = Utils.getApi().getPlace();
//
//        placesCall.enqueue(new Callback<Places>() {
//            @Override
//            public void onResponse(Call<Places> call, Response<Places> response) {
//                homeView.hideLoading();
//
//                if (response.isSuccessful() && response.body() != null) {
//
//                    homeView.setPlaces(response.body().getPlaces());
//
//                }
//                else {
//
//                    homeView.onErrorLoading(response.message());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Places> call, Throwable t) {
//
//                /*
//                 * Failure will be thrown here
//                 * for this you must do
//                 * 1. closes loading
//                 * 2. displays an error message
//                 */
//
//                homeView.onErrorLoading(t.getLocalizedMessage());
//
//            }
//        });
//    }
//
//    void getCategory(){
//
//        homeView.showLoading();
//
//        Call<Category> categoryCall = Utils.getApi().getCategory();
//
//        categoryCall.enqueue(new Callback<Category>() {
//            @Override
//            public void onResponse(@NonNull Call<Category> call, @NonNull Response<Category> response) {
//
//                homeView.hideLoading();
//
//                if (response.isSuccessful() && response.body() != null) {
//
//                    homeView.setCategory(response.body().getCategories());
//
//
//                }
//                else {
//
//                    homeView.hideLoading();
//                    homeView.onErrorLoading(response.message());
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Category> call, @NonNull Throwable t) {
//
//                homeView.hideLoading();
//                homeView.onErrorLoading(t.getLocalizedMessage());
//
//            }
//        });
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
