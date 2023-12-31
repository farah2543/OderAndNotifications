package com.example.demo.service;
import com.example.demo.DataBase;
import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.UserAccount;
import com.example.demo.model.Status;
import com.example.demo.service.System.Notification.NotificationCreator;
import com.example.demo.service.System.Notification.NotificationManager;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceImplementation {
    public boolean loginUser(Account user) {
        UserAccount test = DataBase.getUserAccount(user.getId()) ;
        if (test != null) {
            if (test.getPassword().equals(user.getPassword()) && test.getUsername().equals(user.getUsername())) {
                DataBase.setAuthUser(test);
                return true ;
            }else {
                return false ;
            }
        }else {
            return false ;
        }
    }
    public boolean registerUser(UserAccount user) {
        // some validation may be added
        if (DataBase.getUserAccount(user.getId()) != null) {
            return false ;
        }
        DataBase.saveUserAccount(user);
        return true ;
    }
    public Account getUser(Long id) {
        return DataBase.getUserAccount(id) ;
    }
    public List<Account> getAllUsers () {
        return DataBase.getAllUserAccounts() ;
    }
    public List<Product> getAllProducts() {
        return DataBase.getAllProducts() ;
    }
    public boolean addOrder(Long OrderID) {
        // max 2
        // can't add order of my self
        Order order = DataBase.getOrder(OrderID) ;
        if (order != null){
            DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()).getCart().addItem(order);
            return true ;
        }else {
            return false ;
        }
    }
    public boolean addProduct(Long ProductID) {
        if (DataBase.getProduct(ProductID) != null){
            UserAccount currentAccount = DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()) ;
            currentAccount.getCart().addItem(DataBase.getProduct(ProductID));
            DataBase.deleteProduct(ProductID);
            return true ;
        }else {
            return false ;
        }
    }
    public Order convertCartToOrder() {
        UserAccount currentAccount = DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()) ;
        Order order = new Order(currentAccount.getCart().getItems());
        order.setUser(currentAccount.getId());
        order.totalPrice() ;
        order.assignObservers() ;
        order.setStatus(Status.Saved);
        DataBase.orders.put(order.getId() , order) ;
        currentAccount.getCart().getItems().clear();
        return order ;
    }

    // check if there is notification to send
    public void checkNotification () {
        NotificationManager.GetFirstNotification();
    }

    // pay the order
    public void payOrder (Long OrderID) {
        // check user
        // balance deduction
        // check location
        // fee
        Order o = DataBase.getOrder(OrderID) ;
        o.setStatus(Status.Placed);
    }
}
