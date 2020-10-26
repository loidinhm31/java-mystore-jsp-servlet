/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.dao;

import com.july.myweb.model.Cart;
import com.july.myweb.model.Orders;
import com.july.myweb.model.Product;
import com.july.myweb.utils.DatabaseUtil;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Loi Dinh Oct 24, 2020
 * @version 1.0
 */
public class OrdersDAO {
    private DatabaseUtil dbUtil = DatabaseUtil.getInstance();
    
    public void insertOrder (Orders order, Cart cart) throws SQLException {
        
        // Insert an order into "orders", then get order_id was created
        List<String> orderFields = new ArrayList<>();
        orderFields.add("user_mail");
        orderFields.add("order_address");
        orderFields.add("order_discount_code");
        
        
        List<String> orderValues = new ArrayList<>();
        orderValues.add(order.getUserMail());
        orderValues.add(order.getAddress());
        orderValues.add(order.getDiscount());
        
        
        int orderId = (int) dbUtil.insertDb("orders", orderFields, orderValues);        
        
        // Insert the detail of an order into "order_detail"
        List<Product> listProducts = cart.getItems();
        //
        List<String> orderDetailFields = new ArrayList<>();
        orderDetailFields.add("order_id");
        orderDetailFields.add("product_id");
        orderDetailFields.add("quantity_product");
        orderDetailFields.add("price_product");
        //
        
        
        
        for (Product item : listProducts) {
            List<String> orderDetailValues = new ArrayList<>();
            orderDetailValues.add(String.valueOf(orderId));
            orderDetailValues.add(String.valueOf(item.getId()));
            orderDetailValues.add(String.valueOf(item.getQuantity()));
            orderDetailValues.add(String.valueOf(item.getPrice()));
            
            dbUtil.insertDb("orders_detail", orderDetailFields, orderDetailValues);
        }
        
     
        
        
        //
        dbUtil.closeConnection();
    }
}
