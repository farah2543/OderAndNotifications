package com.example.demo.model;
import com.example.demo.DataBase;
import com.example.demo.service.Observable;
import com.example.demo.service.Observer;
import com.example.demo.service.System.Notification.NotificationCreator;
import com.example.demo.service.System.OrderManagerAndCart.CartItem;

import java.util.ArrayList;
public class Order extends CartItem implements Observable {
    // so this class contribute in 2 design patterns should we make a handler to contribute with observer a
    // and make this class only for composite ??
    // the logic of order as a observable in observer design pattern
    ArrayList<Observer> observers ;
    @Override
    public void AddObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void RemoveObserver(Observer observer) {
        observers.remove(observer) ;
    }
    @Override
    public void NotifyAll() {
        observers.forEach(observer -> observer.update(status));
    }

    // the whole logic of the order as a composite in composite design pattern
    ArrayList<CartItem> items ;
    Long userID ;
    Status status ;
    public Order () {
        super(DataBase.lastOrderID, 0.0) ;
        DataBase.lastOrderID ++ ;
        items = new ArrayList<>() ;
        observers = new ArrayList<>() ;
    }
    public Order (ArrayList<CartItem> items) {
        super(DataBase.lastOrderID, 0.0) ;
        DataBase.lastOrderID ++ ;
        this.items = new ArrayList<>() ;
        this.observers = new ArrayList<>() ;
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
    public ArrayList<Observer> assignObservers () {
        UserAccount account = DataBase.getUserAccount(userID) ;
        if (observers.isEmpty()) {
            NotificationCreator n = new NotificationCreator(this , account , this.status);
        }
        for (CartItem item : items) {
            if (item instanceof Order) {
                ArrayList<Observer>customerInSide ;
                customerInSide = ((Order) item).assignObservers();
                customerInSide.forEach(item1 -> observers.add(item1));
            }
        }
        return observers;
    }
    public Status getStatus() {
        return status;
    }

    public Long getUserID() {
        return userID;
    }

    public void setItems(ArrayList<CartItem> items) {
        items.forEach(item -> this.items.add(item));
    }

    public void setStatus(Status status) {
        this.status = status;
        NotifyAll();
    }

    public void setUser(Long userID) {
        this.userID = userID;
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
                "User id : " + userID + "\n" +
                "Status : " + status + "\n" +
                "List : " + items  ;
    }
}
