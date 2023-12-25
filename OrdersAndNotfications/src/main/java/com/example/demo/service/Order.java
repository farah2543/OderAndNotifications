package com.example.demo.service;

import java.util.ArrayList;

public class Order extends CartItem {

    ArrayList<CartItem> items ;
    public Order (int id) {
        this.id = id ;
        items = new ArrayList<>() ;
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
    public void addItem (CartItem item) {
        this.items.add(item) ;
    }
    public double getPrice() {
        return this.price ;
    }
}
