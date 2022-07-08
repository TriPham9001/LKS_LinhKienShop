package com.example.lks_linhkienshop.Model;

public class Search {
    private int image;
    private String tenSp;
    private String giaSp;

    public Search() {
    }

    public Search(int image, String tenSp, String giaSp) {
        this.image = image;
        this.tenSp = tenSp;
        this.giaSp = giaSp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getGiaSp() {
        return giaSp;
    }

    public void setGiaSp(String giaSp) {
        this.giaSp = giaSp;
    }
}
