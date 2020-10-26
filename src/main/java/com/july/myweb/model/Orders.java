/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.july.myweb.model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Loi Dinh Oct 24, 2020
 * @version 1.0
 */
public class Orders {
    private int orderId;
    private float price;
    private int status;
    private Date orderDate;
    private String address;
    private String phoneNumber;
    private List<ProductOrders> listOrders;
    private String userMail;
    private Date receiveDate;
    private String discount;
    
    public Orders(String userMail, String discount, String address) {
        this.userMail = userMail;
        this.discount = discount;
        this.address = address;
    }
    
    public Orders(int orderId, float price, int status, Date orderDate, String address, String phoneNumber, List<ProductOrders> listOrders, String userMail, Date receiveDate, String discount) {
        this.orderId = orderId;
        this.price = price;
        this.status = status;
        this.orderDate = orderDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.listOrders = listOrders; ///////////////////////????????????????
        this.userMail = userMail;
        this.receiveDate = receiveDate;
        this.discount = discount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<ProductOrders> getListOrders() {
        return listOrders;
    }

    public void setListOrders(List<ProductOrders> listOrders) {
        this.listOrders = listOrders;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
    
    
}
