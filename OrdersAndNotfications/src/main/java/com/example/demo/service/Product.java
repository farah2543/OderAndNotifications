package com.example.demo.service;

public class Product extends CartItem{
    public Product(int id , double price) {
        this.price = price ;
        this.id = id ;
    }
    @Override
    public double totalPrice() {
        return this.price ;
    }
}
