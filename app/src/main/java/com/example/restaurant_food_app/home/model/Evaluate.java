package com.example.restaurant_food_app.home.model;

public class Evaluate {
    int thumbnailEva;
    String titleEva, amountEva;

    public Evaluate(int thumbnailEva, String titleEva, String amountEva) {
        this.thumbnailEva = thumbnailEva;
        this.titleEva = titleEva;
        this.amountEva = amountEva;
    }

    public int getThumbnailEva() {
        return thumbnailEva;
    }

    public void setThumbnailEva(int thumbnailEva) {
        this.thumbnailEva = thumbnailEva;
    }

    public String getTitleEva() {
        return titleEva;
    }

    public void setTitleEva(String titleEva) {
        this.titleEva = titleEva;
    }

    public String getAmountEva() {
        return amountEva;
    }

    public void setAmountEva(String amountEva) {
        this.amountEva = amountEva;
    }
}
