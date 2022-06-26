package com.example.lks_linhkienshop.Model;

public class Product {

    private int id;
    private int idTheLoai;
    private int idCompany;
    private String imgUrl;
    private String tenSanPham;
    private Number donGia;
    private String moTa;
    private Boolean trangThaiSp;

    public Product() {
    }

    public Product(int id, int idTheLoai, int idCompany, String imgUrl, String tenSanPham, Number donGia, String moTa, Boolean trangThaiSp) {
        this.id = id;
        this.idTheLoai = idTheLoai;
        this.idCompany = idCompany;
        this.imgUrl = imgUrl;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThaiSp = trangThaiSp;
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

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public Number getDonGia() {
        return donGia;
    }

    public void setDonGia(Number donGia) {
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
}