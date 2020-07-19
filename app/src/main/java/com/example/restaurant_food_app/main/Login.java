package com.example.restaurant_food_app.main;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("id_taikhoan")
    @Expose
    private Integer idTaikhoan;
    @SerializedName("nguoidung")
    @Expose
    private String nguoidung;
    @SerializedName("matkhau")
    @Expose
    private String matkhau;
    @SerializedName("ten")
    @Expose
    private Object ten;
    @SerializedName("sdt")
    @Expose
    private Integer sdt;
    @SerializedName("diachi")
    @Expose
    private String diachi;
    @SerializedName("vung")
    @Expose
    private String vung;
    @SerializedName("avt")
    @Expose
    private Object avt;
    @SerializedName("quyen")
    @Expose
    private String quyen;

    /**
     * No args constructor for use in serialization
     *
     */
    public Login() {
    }

    /**
     *
     * @param diachi
     * @param quyen
     * @param sdt
     * @param matkhau
     * @param idTaikhoan
     * @param nguoidung
     * @param ten
     * @param avt
     * @param vung
     */
    public Login(Integer idTaikhoan, String nguoidung, String matkhau, Object ten, Integer sdt, String diachi, String vung, Object avt, String quyen) {
        super();
        this.idTaikhoan = idTaikhoan;
        this.nguoidung = nguoidung;
        this.matkhau = matkhau;
        this.ten = ten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.vung = vung;
        this.avt = avt;
        this.quyen = quyen;
    }

    public Integer getIdTaikhoan() {
        return idTaikhoan;
    }

    public void setIdTaikhoan(Integer idTaikhoan) {
        this.idTaikhoan = idTaikhoan;
    }

    public String getNguoidung() {
        return nguoidung;
    }

    public void setNguoidung(String nguoidung) {
        this.nguoidung = nguoidung;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public Object getTen() {
        return ten;
    }

    public void setTen(Object ten) {
        this.ten = ten;
    }

    public Integer getSdt() {
        return sdt;
    }

    public void setSdt(Integer sdt) {
        this.sdt = sdt;
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

    public Object getAvt() {
        return avt;
    }

    public void setAvt(Object avt) {
        this.avt = avt;
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

}
