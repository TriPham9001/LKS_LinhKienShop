package com.example.lks_linhkienshop.Model;

public class Search {
    private int id;
    private String tenSp;
    private String giaSp;
    private Float donGia;
    private String moTa;
    private Float discount;

    public Search() {
    }

    public Search(String tenSp) {
        this.tenSp = tenSp;
    }

    public Search(int id, String tenSp, String giaSp, Float donGia, String moTa, Float discount) {
        this.id = id;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
        this.donGia = donGia;
        this.moTa = moTa;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getGiaSp() {
        giaSp = String.valueOf(donGia);
        return giaSp;
    }

    public void setGiaSp(String giaSp) {
        this.giaSp = giaSp;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
