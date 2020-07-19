package com.example.restaurant_food_app.home.model;

public class CategoryPlaces {
    int imagePlaces;
    String titlePlaces, desPlaces;

    public CategoryPlaces(int imagePlaces, String titlePlaces, String desPlaces) {
        this.imagePlaces = imagePlaces;
        this.titlePlaces = titlePlaces;
        this.desPlaces = desPlaces;
    }

    public int getImagePlaces() {
        return imagePlaces;
    }

    public void setImagePlaces(int imagePlaces) {
        this.imagePlaces = imagePlaces;
    }

    public String getTitlePlaces() {
        return titlePlaces;
    }

    public void setTitlePlaces(String titlePlaces) {
        this.titlePlaces = titlePlaces;
    }

    public String getDesPlaces() {
        return desPlaces;
    }

    public void setDesPlaces(String desPlaces) {
        this.desPlaces = desPlaces;
    }
}
