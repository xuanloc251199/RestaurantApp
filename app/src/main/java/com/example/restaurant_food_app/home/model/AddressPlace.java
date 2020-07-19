package com.example.restaurant_food_app.home.model;

public class AddressPlace {
    int thumbnailAdd;
    String titleAdd;

    public AddressPlace(int thumbnailAdd, String titleAdd) {
        this.thumbnailAdd = thumbnailAdd;
        this.titleAdd = titleAdd;
    }

    public int getThumbnailAdd() {
        return thumbnailAdd;
    }

    public void setThumbnailAdd(int thumbnailAdd) {
        this.thumbnailAdd = thumbnailAdd;
    }

    public String getTitleAdd() {
        return titleAdd;
    }

    public void setTitleAdd(String titleAdd) {
        this.titleAdd = titleAdd;
    }
}
