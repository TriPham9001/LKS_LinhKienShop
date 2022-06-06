package com.example.lks_linhkienshop.Model;

public class Product {

    private int image;
    private String name;
    private String price;
    private String describe;

    public Product() {
    }

    public Product(int image, String name, String price, String describe) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.describe = describe;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}