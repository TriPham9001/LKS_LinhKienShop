package com.example.lks_linhkienshop.Model;

import com.example.lks_linhkienshop.Fragment.PersonFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDon {
    private int id;
    private int idNhanVien;
    private int idKhachHang;
    private int idVoucher;
    private String diaChi;
    private int trangThaiHD;
    private String ngayMua;

    //FOREIGN KEY idNhanVien,idKhachHang,idVoucher


    public HoaDon(int idVoucher) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        this.idNhanVien = 1;
        this.idKhachHang = PersonFragment.khachHanginfo.getId();
        this.idVoucher = idVoucher;
        this.diaChi = PersonFragment.khachHanginfo.getDiaChi();
        this.ngayMua = formatter.format(date);
    }

    public HoaDon() {
    }

    public HoaDon(int id, int idNhanVien, int idKhachHang, int idVoucher, String diaChi, int trangThaiHD, String ngayMua) {
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

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }
}
