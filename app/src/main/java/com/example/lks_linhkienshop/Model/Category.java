package com.example.lks_linhkienshop.Model;

public class Category {

    private int id;
    private String tenTheLoai;

    public Category() {
    }

    public Category(int id, String tenTheLoai) {
        this.id = id;
        this.tenTheLoai = tenTheLoai;
    }

    public Category(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }


}