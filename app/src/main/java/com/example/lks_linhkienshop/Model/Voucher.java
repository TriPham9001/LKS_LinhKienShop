package com.example.lks_linhkienshop.Model;

import java.util.Date;

public class Voucher {
    private int id;
    private int idSanPham;
    private String tenVoucher;
    private Number discount;
    private Date date;

    //FOREIGN KEY idSanPham

    public Voucher() {
    }

    public Voucher(int id, int idSanPham, String tenVoucher, Number discount, Date date) {
        this.id = id;
        this.idSanPham = idSanPham;
        this.tenVoucher = tenVoucher;
        this.discount = discount;
        this.date = date;
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

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public Number getDiscount() {
        return discount;
    }

    public void setDiscount(Number discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
