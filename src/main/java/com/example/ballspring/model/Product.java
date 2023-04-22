package com.example.ballspring.model;

public class Product {
    private String pName;
    private String pImg;
    private String pLink;
    private String bTitle;
    private String bIcon;
    private Integer pPrice;

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    public String getbIcon() {
        return bIcon;
    }

    public void setbIcon(String bIcon) {
        this.bIcon = bIcon;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImg() {
        return pImg;
    }

    public void setpImg(String pImg) {
        this.pImg = pImg;
    }

    public String getpLink() {
        return pLink;
    }

    public void setpLink(String pLink) {
        this.pLink = pLink;
    }

    public Integer getpPrice() {
        return pPrice;
    }

    public void setpPrice(Integer pPrice) {
        this.pPrice = pPrice;
    }
}
