package com.example.demo.model;

import com.example.demo.service.System.Message.Lang;
import com.example.demo.service.System.OrderManagerAndCart.Cart;

public class UserAccount extends Account{
    Cart cart ;
    String name , phone , address ;
    double balance ;
    Lang preferedLang ;
    public UserAccount(Long id , String username , String password , Cart cart , String name , String phone , String address , Lang lang) {
        super(id , username , password) ;
        this.cart = cart ;
        this.name = name ;
        this.phone = phone ;
        this.address = address ;
        this.preferedLang = lang ;
    }

    public double getBalance() {
        return balance;
    }

    public Lang getPreferedLang() {
        return preferedLang;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Cart getCart() {
        return cart;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPreferedLang(Lang preferedLang) {
        this.preferedLang = preferedLang;
    }
    @Override
    public String toString() {
        return super.toString() + "name : " + name + "\n"
                + "phone : " + phone + "\n"
                + "address : " + address + "\n"
                + "balance : " + balance + "\n"
                + "Lang : " + preferedLang + "\n" ;
    }
}