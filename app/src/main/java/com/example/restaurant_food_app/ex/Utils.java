//package com.example.restaurant_food_app.home;
//
//import android.app.AlertDialog;
//import android.content.Context;
//
//import com.example.restaurant_food_app.home.api.PlacesAPI;
//import com.example.restaurant_food_app.home.api.PlacesClient;
//
//public class Utils {
//
//    public static PlacesAPI getApi() {
//        return PlacesClient.getFoodClient().create(PlacesAPI.class);
//    }
//
//    public static AlertDialog showDialogMessage(Context context, String title, String message) {
//        AlertDialog alertDialog = new AlertDialog.Builder(context).setTitle(title).setMessage(message).show();
//        if (alertDialog.isShowing()) {
//            alertDialog.cancel();
//        }
//        return alertDialog;
//    }
//}
