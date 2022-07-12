package com.example.lks_linhkienshop.Model;

public class KhachHang {
    private int id;
    private String tenKH;
    private String diaChi;
    private String matKhau;
    private String soDT;

    public KhachHang(int id, String tenKH, String diaChi, String matKhau, String soDT) {
        this.id = id;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.matKhau = matKhau;
        this.soDT = soDT;
    }

    public KhachHang() {
    }

    public KhachHang(String soDT, String matKhau) {
        this.matKhau = matKhau;
        this.soDT = soDT;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}
