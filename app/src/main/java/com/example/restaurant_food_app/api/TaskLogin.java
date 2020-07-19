//package com.example.restaurant_food_app.api;
//
//import android.os.AsyncTask;
//import android.widget.Toast;
//
//import com.example.restaurant_food_app.main.Login;
//
//import java.io.IOException;
//
//import okhttp3.FormBody;
//import okhttp3.OkHttpClient;
//import okhttp3.FormBody;
//import okhttp3.Request;
//import okhttp3.Request.Builder;
//import okhttp3.Response;
//import okhttp3.ResponseBody;
//
//public class TaskLogin extends AsyncTask<String, Void, String> {
//
//    private static final String BASE_URL = "http://172.16.1.181/webproject/public/dangnhap";
//
//
//
//    @Override
//    protected String doInBackground(String... strings) {
//
//
//        String userName = strings[0];
//        String passWork = strings[1];
//
//        OkHttpClient client = new OkHttpClient();
//        FormBody responseBody = new FormBody.Builder()
//                .add("nguoidung", userName)
//                .add("matkhau", passWork)
//                .build();
//
//        Request request = new Request.Builder().url(BASE_URL).build();
//
//
//        Response response = null;
//
//
//        try {
//
//            response = client.newCall(request).execute();
//            if (response.isSuccessful()){
//
//                String result = response.body().string();
//                if (result.equalsIgnoreCase("login")){
//
//                }else {
//
//                }
//
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
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
