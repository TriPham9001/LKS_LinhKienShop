package com.example.lks_linhkienshop.Model;

public class CTHD {
    private int id;
    private int idHoaDon;
    private int idSanPham;
    private int soLuong;

    //FOREIGN KEY idHoaDon,idSanPham

    public CTHD() {
    }

    public CTHD(int id, int idHoaDon, int idSanPham, int soLuong) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idSanPham = idSanPham;
        this.soLuong = soLuong;
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
}
