package com.example.restaurant_food_app.home.model;

public class NearMePlaces {
    int imgPlace;
    String namePlace, desPlace;

    public NearMePlaces(int imgPlace, String namePlace, String desPlace) {
        this.imgPlace = imgPlace;
        this.namePlace = namePlace;
        this.desPlace = desPlace;
    }

    public int getImgPlace() {
        return imgPlace;
    }

    public void setImgPlace(int imgPlace) {
        this.imgPlace = imgPlace;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getDesPlace() {
        return desPlace;
    }

    public void setDesPlace(String desPlace) {
        this.desPlace = desPlace;
    }
}
