package com.example.restaurant_food_app.home.model;

public class NearbyPlace {
    int imgNeatbyPlace;
    String titleNearbyPlace, desNearbyPlace;

    public NearbyPlace(int imgNeatbyPlace, String titleNearbyPlace, String desNearbyPlace) {
        this.imgNeatbyPlace = imgNeatbyPlace;
        this.titleNearbyPlace = titleNearbyPlace;
        this.desNearbyPlace = desNearbyPlace;
    }

    public int getImgNeatbyPlace() {
        return imgNeatbyPlace;
    }

    public void setImgNeatbyPlace(int imgNeatbyPlace) {
        this.imgNeatbyPlace = imgNeatbyPlace;
    }

    public String getTitleNearbyPlace() {
        return titleNearbyPlace;
    }

    public void setTitleNearbyPlace(String titleNearbyPlace) {
        this.titleNearbyPlace = titleNearbyPlace;
    }

    public String getDesNearbyPlace() {
        return desNearbyPlace;
    }

    public void setDesNearbyPlace(String desNearbyPlace) {
        this.desNearbyPlace = desNearbyPlace;
    }
}
