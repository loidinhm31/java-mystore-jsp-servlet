/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Loi Dinh Oct 24, 2020
 * @version 1.0
 */
public class Cart {
    private List<Product> listProducts;
   
    public Cart() {
        listProducts = new ArrayList<>();
    }
    
    /**
     * Add a new product to the cart
     * 
     * @param currItem
     */
    public void addItem(Product currItem) {
        for (Product inList : listProducts) {
            if (currItem.getId() == inList.getId()) {
                inList.setQuantity(inList.getQuantity()+ 1);
                return;
            }
        }
        
        listProducts.add(currItem);
    }
    
    /**
     * Remove a product from the cart
     * 
     * @param id 
     */
    public void removeItem(int id) {
        for (Product inList : listProducts) {
            if (inList.getId() == id) {
                listProducts.remove(inList);
                return;
            }
        }
    }
    
    
    /**
     * Return total amount of the cart
     * 
     * @return 
     */
    public double getAmount() {
        double total = 0;
        for (Product inList : listProducts) {
            total += inList.getPrice() * inList.getQuantity();
        }
        
        return Math.round(total * 100.0) / 100.0;
    }
    
    
    /**
     * Return list of products in the cart
     * 
     * @return 
     */
    public List<Product> getItems() {
        return listProducts;
    }
}
