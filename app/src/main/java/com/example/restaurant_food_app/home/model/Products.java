package com.example.restaurant_food_app.home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Products {

    @SerializedName("id_diadiem")
    @Expose
    private Integer idDiadiem;
    @SerializedName("name_sanpham")
    @Expose
    private String nameSanpham;
    @SerializedName("gia")
    @Expose
    private Integer gia;
    @SerializedName("avt_sanpham")
    @Expose
    private String avtSanpham;

    /**
     * No args constructor for use in serialization
     *
     */
    public Products() {
    }

    /**
     *
     * @param avtSanpham
     * @param nameSanpham
     * @param gia
     * @param idDiadiem
     */
    public Products(Integer idDiadiem, String nameSanpham, Integer gia, String avtSanpham) {
        super();
        this.idDiadiem = idDiadiem;
        this.nameSanpham = nameSanpham;
        this.gia = gia;
        this.avtSanpham = avtSanpham;
    }

    public Integer getIdDiadiem() {
        return idDiadiem;
    }

    public void setIdDiadiem(Integer idDiadiem) {
        this.idDiadiem = idDiadiem;
    }

    public String getNameSanpham() {
        return nameSanpham;
    }

    public void setNameSanpham(String nameSanpham) {
        this.nameSanpham = nameSanpham;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getAvtSanpham() {
        return avtSanpham;
    }

    public void setAvtSanpham(String avtSanpham) {
        this.avtSanpham = avtSanpham;
    }

}
