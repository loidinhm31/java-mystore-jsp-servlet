/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.model;

/**
 *
 * @author Loi Dinh Oct 20, 2020
 * @version 1.0
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private float price;
    private String src;
    private String type;
    private String brand;
    private int quantity;

    public Product(int id, String name, String description, float price, String src, String type, String brand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.src = src;
        this.type = type;
        this.brand = brand;
    }
    
    public Product(int id, String name, String description, float price, String src, String type, String brand, int quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.src = src;
        this.type = type;
        this.brand = brand;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

  
    
    
}
