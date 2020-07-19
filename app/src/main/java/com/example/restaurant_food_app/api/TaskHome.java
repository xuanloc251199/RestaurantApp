package com.example.restaurant_food_app.api;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TaskHome extends AsyncTask<String,String,String> {

    // 172.16.1.181  192.168.43.124

    private static final String BASE_URL = "http://192.168.43.124/webproject/public/APIdiadiemnoibat";
    private NetworkResponseListener networkResponseListener;

    public TaskHome(NetworkResponseListener networkResponseListener){
        this.networkResponseListener = networkResponseListener;
    }

    @Override
    protected String doInBackground(String... strings) {

        OkHttpClient client=new OkHttpClient();
        client.retryOnConnectionFailure();
        client.newBuilder().connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(3000,TimeUnit.SECONDS)
                .readTimeout(3000,TimeUnit.SECONDS)
                .build();

        //Calling Demo Data APi
        Request request = new Request.Builder().url(BASE_URL).build();
        Response response = null;

        try {
            response=client.newCall(request).execute();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        if(response!=null && response.isSuccessful()){
            try{
                if(response.body()!=null){
                    return response.body().string();
                }
                else{
                    return  null;
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s != null){
            networkResponseListener.SuccessData(s);
        }
        else{
            networkResponseListener.FailedData();
        }
    }
}
