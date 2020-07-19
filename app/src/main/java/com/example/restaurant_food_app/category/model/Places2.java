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
    @SerializedName("bando")
    @Expose
    private String bando;
    @SerializedName("danhgia")
    @Expose
    private Float danhgia;
    @SerializedName("theloai")
    @Expose
    private String theloai;

    /**
     * No args constructor for use in serialization
     *
     */
    public Places2() {
    }

    /**
     *
     * @param theloai
     * @param diachi
     * @param lienhe
     * @param bando
     * @param avtDiadiem
     * @param ten
     * @param danhgia
     * @param close
     * @param open
     * @param idDiadiem
     * @param vung
     */
    public Places2(Integer idDiadiem, String ten, String diachi, String vung, String lienhe, String open, String close, String avtDiadiem, String bando, Float danhgia, String theloai) {
        super();
        this.idDiadiem = idDiadiem;
        this.ten = ten;
        this.diachi = diachi;
        this.vung = vung;
        this.lienhe = lienhe;
        this.open = open;
        this.close = close;
        this.avtDiadiem = avtDiadiem;
        this.bando = bando;
        this.danhgia = danhgia;
        this.theloai = theloai;
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

    public String getBando() {
        return bando;
    }

    public void setBando(String bando) {
        this.bando = bando;
    }

    public Float getDanhgia() {
        return danhgia;
    }

    public void setDanhgia(Float danhgia) {
        this.danhgia = danhgia;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }


}
