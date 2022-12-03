package com.alex.store;

public class Product {
    private int id;
    private String title;
    private float coast;

    public Product(int id, String name, float coast) {
        this.id = id;
        this.title = name;
        this.coast = coast;
    }

    @Override
    public String toString() {
        return "id=" + id + ", product name='" + title + ", coast=" + coast;
    }

    public int getId() {
        return id;
    }
}
