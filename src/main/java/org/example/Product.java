package org.example;

public class Product {
    public Product(String name, int cost, int quantity) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
    }

    private String name ;
    private int cost;
    private int quantity;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Product( int cost, int quantity) {

        this.cost = cost;
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }



}
