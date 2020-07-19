package com.example.restaurant_food_app.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {



    @SerializedName("id_theloai")
    @Expose
    private Integer idTheloai;
    @SerializedName("theloai")
    @Expose
    private String theloai;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public Category(Integer idTheloai, String theloai, String thumbnail) {
        this.idTheloai = idTheloai;
        this.theloai = theloai;
        this.thumbnail = thumbnail;
    }

    public Integer getIdTheloai() {
        return idTheloai;
    }

    public void setIdTheloai(Integer idTheloai) {
        this.idTheloai = idTheloai;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void changeText1(String text) {
    }
}
