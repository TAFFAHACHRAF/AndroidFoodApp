package com.example.chnonakelapp.models;

public class FoodItem {
    private String name;
    private double price;
    private String imageName;

    public FoodItem(){}

    public FoodItem(String name, double price,String imageName) {
        this.name = name;
        this.price = price;
        this.imageName=imageName;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getImageName() { return imageName; }
}
