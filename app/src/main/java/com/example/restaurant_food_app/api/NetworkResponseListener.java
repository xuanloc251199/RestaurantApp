package com.example.restaurant_food_app.api;

public interface NetworkResponseListener {

    //Handle When We Recevie Success Data
    void SuccessData(String data);

    //When We Received Fail Response
    void FailedData();

}
