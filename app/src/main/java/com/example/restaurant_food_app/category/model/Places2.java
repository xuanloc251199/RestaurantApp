package com.example.restaurant_food_app.category.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Places2 {

    @SerializedName("id_diadiem")
    @Expose
    private Integer idDiadiem;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("vung")
    @Expose
    private String vung;
    @SerializedName("lienhe")
    @Expose
    private String lienhe;
    @SerializedName("open")
    @Expose
    private String open;
    @SerializedName("close")
    @Expose
    private String close;
    @SerializedName("avt_diadiem")
    @Expose
    private String avtDiadiem;
    @SerializedName("danhgia")
    @Expose
    private Double danhgia;
    @SerializedName("theloai")
    @Expose
    private String theloai;
    @SerializedName("x")
    @Expose
    private Double x;
    @SerializedName("y")
    @Expose
    private Double y;

    public Places2(Integer idDiadiem, String ten, String diachi, String vung, String lienhe, String open, String close, String avtDiadiem, Double danhgia, String theloai, Double x, Double y) {
        this.idDiadiem = idDiadiem;
        this.ten = ten;
        this.diachi = diachi;
        this.vung = vung;
        this.lienhe = lienhe;
        this.open = open;
        this.close = close;
        this.avtDiadiem = avtDiadiem;
        this.danhgia = danhgia;
        this.theloai = theloai;
        this.x = x;
        this.y = y;
    }

    public Integer getIdDiadiem() {
        return idDiadiem;
    }

    public void setIdDiadiem(Integer idDiadiem) {
        this.idDiadiem = idDiadiem;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getVung() {
        return vung;
    }

    public void setVung(String vung) {
        this.vung = vung;
    }

    public String getLienhe() {
        return lienhe;
    }

    public void setLienhe(String lienhe) {
        this.lienhe = lienhe;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getAvtDiadiem() {
        return avtDiadiem;
    }

    public void setAvtDiadiem(String avtDiadiem) {
        this.avtDiadiem = avtDiadiem;
    }

    public Double getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(Double danhgia) {
        this.danhgia = danhgia;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }


}
