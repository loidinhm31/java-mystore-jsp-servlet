/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.july.prj321x.a2.beans;

/**
 *
 * @author Dawn
 */
public class Account {
    private String userId;
    private String pwd;
    private int role;
    private String name, address, phone;
    private int check;
    
    public Account() {
        
    }
    
    public Account(String userId, String pwd, int role, String name, String address, String phone, int check) {
        this.userId = userId;
        this.pwd = pwd;
        this.role = role;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.check = check;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String user) {
        this.userId = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
    
    
}
