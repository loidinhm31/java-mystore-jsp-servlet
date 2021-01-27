package com.july.mystore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> shoppingProducts;
	   
    public Cart() {
    	shoppingProducts = new ArrayList<>();
    }
    
    /**
     * Add a new product to the cart
     * 
     * @param currItem
     */
    public void addItem(Product currItem) {
    	
    	for (Product productInCart : shoppingProducts) {
    		
            if (currItem.getProductSKU().equals(productInCart.getProductSKU())) {
            	int inCartQuantity = productInCart.getInCartQuantity();
            	
            	productInCart.setInCartQuantity(inCartQuantity + 1);;
                return;
            } 
        }
    	
    	
    	// If the cart has not the current product, 
    	// then add the product into the cart
    	// and increase the quantity of it
    	currItem.setInCartQuantity(1);
    	
        shoppingProducts.add(currItem);
    	
    }
    
    /**
     * Remove a product from the cart
     * 
     * @param id 
     */
    public void removeItem(String productCode) {
        for (Product productInCart : shoppingProducts) {
            if (productInCart.getProductSKU().equalsIgnoreCase(productCode)) {
                shoppingProducts.remove(productInCart);
                return;
            }
        }
    }
    
    
    /**
     * Return total price of the cart
     * 
     * @return 
     */
    public double getTotalPrice() {
        double total = 0;
        for (Product productInCart : shoppingProducts) {
            total += productInCart.getProductPrice() * productInCart.getInCartQuantity();
        }
        
        return Math.round(total * 100.0) / 100.0;
    }
    
    
    /**
     * Return list of products in the cart
     * 
     * @return 
     */
    public List<Product> getItems() {
        return shoppingProducts;
    }
    
    
    public void clearCart() {
    	shoppingProducts.clear();
    }

}
