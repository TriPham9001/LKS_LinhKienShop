package com.example.lks_linhkienshop.Model;

public class CTHD {
    private int id;
    private int idHoaDon;
    private int idSanPham;
    private int soLuong;
    private String tenSanPham;
    private float donGia;

    //FOREIGN KEY idHoaDon,idSanPham

    public CTHD() {
    }

    public CTHD(int id, int idHoaDon, int idSanPham, int soLuong, String tenSanPham, float donGia) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
    }

    public CTHD(int idSanPham, String tenSanPham, float donGia) {
        this.idSanPham = idSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
    }

    public CTHD(int idSanPham, int soLuong, String tenSanPham, float donGia) {
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }
}
