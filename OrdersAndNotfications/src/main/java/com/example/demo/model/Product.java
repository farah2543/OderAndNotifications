package com.example.demo.model;

import com.example.demo.service.System.OrderManagerAndCart.CartItem;

public class Product extends CartItem {
    public Product(Long id , double price) {
        super(id , price);
    }
    @Override
    public double totalPrice() {
        return this.price ;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
