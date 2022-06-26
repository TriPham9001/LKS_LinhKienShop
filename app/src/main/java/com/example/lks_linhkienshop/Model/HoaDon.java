package com.example.lks_linhkienshop.Model;

import java.util.Date;

public class HoaDon {
    private int id;
    private int idNhanVien;
    private int idKhachHang;
    private int idVoucher;
    private String diaChi;
    private int trangThaiHD;
    private Date ngayMua;

    //FOREIGN KEY idNhanVien,idKhachHang,idVoucher

    public HoaDon() {
    }

    public HoaDon(int id, int idNhanVien, int idKhachHang, int idVoucher, String diaChi, int trangThaiHD, Date ngayMua) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.idVoucher = idVoucher;
        this.diaChi = diaChi;
        this.trangThaiHD = trangThaiHD;
        this.ngayMua = ngayMua;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTrangThaiHD() {
        return trangThaiHD;
    }

    public void setTrangThaiHD(int trangThaiHD) {
        this.trangThaiHD = trangThaiHD;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }
}
