package com.example.demo.model;

import com.example.demo.DataBase;
import com.example.demo.service.System.OrderManagerAndCart.CartItem;
import com.example.demo.service.System.OrderManagerAndCart.Status;

import java.util.ArrayList;
import java.util.List;

public class Order extends CartItem {

    ArrayList<CartItem> items ;
    UserAccount user ;
    Status status ;
    public Order () {
        super(DataBase.lastOrderID, 0.0) ;
        DataBase.lastOrderID ++ ;
        items = new ArrayList<>() ;
    }
    public Order (ArrayList<CartItem> items) {
        super(DataBase.lastOrderID, 0.0) ;
        DataBase.lastOrderID ++ ;
        this.items = new ArrayList<>() ;
        items.forEach(item -> this.items.add(item));
    }
    @Override
    public double totalPrice() {
        double test = 0.0 ;
        for (CartItem i : items){
            if (i instanceof Product) {
                test += i.totalPrice() ;
            }else{
                i.totalPrice() ;
            }
        }
        this.price = test ;
        return test ;
    }

    public Status getStatus() {
        return status;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setItems(ArrayList<CartItem> items) {
        items.forEach(item -> this.items.add(item));
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }
    public void addItem (CartItem item) {
        this.items.add(item) ;
    }
    public double getPrice() {
        return this.price ;
    }

    @Override
    public String toString() {
        return super.toString() +
                "User : " + user + "\n" +
                "Status : " + status + "\n" +
                "List : " + items  ;
    }
}
