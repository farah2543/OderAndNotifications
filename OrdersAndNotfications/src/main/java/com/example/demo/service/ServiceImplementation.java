package com.example.demo.service;
import com.example.demo.DataBase;
import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.UserAccount;
import com.example.demo.service.System.OrderManagerAndCart.Status;
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
        if (DataBase.getProduct(OrderID) != null){
            DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()).getCart().addItem(DataBase.getOrder(OrderID));
            return true ;
        }else {
            return false ;
        }
    }
    public boolean addProduct(Long ProductID) {
        if (DataBase.getProduct(ProductID) != null){
            DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()).getCart().addItem(DataBase.getProduct(ProductID));
            System.out.println(DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()).getCart().getItems());
            return true ;
        }else {
            return false ;
        }
    }

    public Order convertCartToOrder() {
        UserAccount currentAccount = DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()) ;
        System.out.println(currentAccount.getCart().getItems());
        Order order = new Order(DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()).getCart().getItems());
        order.setUser(currentAccount);
        order.setStatus(Status.Saved);
        DataBase.orders.put(order.getId() , order) ;
        DataBase.getUserAccount(DataBase.getCurrentAuthUser().getId()).getCart().getItems().clear();
        return order ;
    }
    //    @Override
//    public void checkOut(Order order) {
//        // add order to list
//        // deduct all products
//        // add notification to all users
//    }
}
