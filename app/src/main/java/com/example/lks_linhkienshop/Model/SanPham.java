package com.example.lks_linhkienshop.Model;

public class SanPham {

    private int id;
    private int idTheLoai;
    private int idCompany;
    private String imgUrl;
    private String tenSP;
    private Float donGia;
    private String moTa;
    private Boolean trangThaiSp;
    private Float discount;

    //FOREIGN KEY idTheLoai,idCompany

    public SanPham() {
    }

    public SanPham(int id, String tenSP, Float donGia, Float discount) {
        this.id = id;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.discount = donGia- discount;
    }

    public SanPham(int id) {
        this.id = id;
    }

    public SanPham(int id, int idTheLoai, int idCompany, String imgUrl, String tenSP, Float donGia, String moTa, Boolean trangThaiSp, Float discount) {
        this.id = id;
        this.idTheLoai = idTheLoai;
        this.idCompany = idCompany;
        this.imgUrl = imgUrl;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThaiSp = trangThaiSp;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Boolean getTrangThaiSp() {
        return trangThaiSp;
    }

    public void setTrangThaiSp(Boolean trangThaiSp) {
        this.trangThaiSp = trangThaiSp;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}