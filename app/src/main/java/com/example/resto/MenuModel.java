package com.example.resto;

public class MenuModel {

    private int dishid;
    private String dishname;
    private int dishprice;
    private boolean isveg;


    //constructor


    public MenuModel(int dishid, String dishname, int dishprice, boolean isveg) {
        this.dishid = dishid;
        this.dishname = dishname;
        this.dishprice = dishprice;
        this.isveg = isveg;
    }

    public MenuModel() {
    }

    //toString

    @Override
    public String toString() {
        return "MenuModel{" +
                "dishid=" + dishid +
                ", dishname='" + dishname + '\'' +
                ", dishprice=" + dishprice +
                ", isveg=" + isveg +
                '}';
    }


    //getters and setters


    public int getDishid() {
        return dishid;
    }

    public void setDishid(int dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public int getDishprice() {
        return dishprice;
    }

    public void setDishprice(int dishprice) {
        this.dishprice = dishprice;
    }

    public boolean isIsveg() {
        return isveg;
    }

    public void setIsveg(boolean isveg) {
        this.isveg = isveg;
    }
}
