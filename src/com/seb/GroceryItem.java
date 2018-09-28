package com.seb;

import java.util.Random;

public class GroceryItem {
    private String itemName;
    private double price;
    private int quantity;
    private double cost;

    public GroceryItem(String itemName, double price, int quantity, double cost) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
        this.cost = cost;
    }

    public GroceryItem() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
