package com.example.lks_linhkienshop.Model;

public class Image {
    private int id;
    private int idSanPham;
    private String imgUrl;

    public Image(int id, int idSanPham, String imgUrl) {
        this.id = id;
        this.idSanPham = idSanPham;
        this.imgUrl = imgUrl;
    }

    public Image() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
