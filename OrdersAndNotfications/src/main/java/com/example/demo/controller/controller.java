package com.example.demo.controller;

import com.example.demo.DataBase;
import com.example.demo.model.Account;
import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.model.UserAccount;
import com.example.demo.service.System.OrderManagerAndCart.Cart;
import com.example.demo.service.ServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


@RestController
public class controller {
    @Autowired
    ServiceImplementation serviceImplementation ;
    public controller () {
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (serviceImplementation != null){
                    serviceImplementation.checkNotification();
                }
            }
        }, 0, 2000) ;
        Product p = new Product(12L , 12.5 , "Test" , "Vendor1" , "Sweets" ) ;
        DataBase.saveProduct(p) ;
        p = new Product(13L , 13.5 , "Test" , "Vendor2" , "Slaves" ) ;
        DataBase.saveProduct(p) ;
        p = new Product(14L , 14.5 , "Test" , "Vendor1" , "Sweets") ;
        DataBase.saveProduct(p) ;
        p = new Product(15L , 15.5 , "Test" , "Vendor2" , "Slaves") ;
        DataBase.saveProduct(p) ;
    }
    @GetMapping("/getUser")
    public Account getUser (@RequestParam(value = "id" ) Long id) {
        return serviceImplementation.getUser(id) ;
    }
    @PostMapping("/AddUserAccount")
    public ResponseEntity<String> add (@RequestBody UserAccount ac) {
        Cart c = new Cart() ;
        ac.setCart(c);
        if (serviceImplementation.registerUser(ac)){
            return ResponseEntity.status(HttpStatus.OK).body("Registered Successfully") ;
        }else {
            return ResponseEntity.status(HttpStatus.OK).body("Id Already Exists") ;
        }
    }
    @PostMapping("/LoginUser")
    public ResponseEntity<String> login (@RequestBody Account ac) {
        if (DataBase.getCurrentAuthUser() == null) {
            if (serviceImplementation.loginUser(ac)) {
                return ResponseEntity.status(HttpStatus.OK).body("Logged In Successfully") ;
            }else {
                return ResponseEntity.status(HttpStatus.OK).body("Wrong Credentials") ;
            }
        }else {
            if (ac.getId().equals(DataBase.getCurrentAuthUser().getId())) {
                return ResponseEntity.status(HttpStatus.OK).body("You Are Already Logged in") ;
            }else {
                return ResponseEntity.status(HttpStatus.OK).body("Can't Log in Because there is a logged in user") ;
            }
        }
    }
    @GetMapping("/Logout")
    public ResponseEntity<String> logout () {
        if (DataBase.getCurrentAuthUser() == null) {
            return ResponseEntity.status(HttpStatus.OK).body("Can't logout Because there is no Logged in user") ;
        }else {
            DataBase.setAuthUser(null);

            return ResponseEntity.status(HttpStatus.OK).body("Logged out successfully") ;
        }
    }
    @GetMapping("/CheckOut")
    public Order checkOut () {
        return serviceImplementation.convertCartToOrder() ;
    }
    @GetMapping("Products")
    public List<Product> getAllProducts () {
        return serviceImplementation.getAllProducts() ;
    }
    @PostMapping("Order")
    public void addOrder (@RequestBody Long orderID) {

    }
    @GetMapping("AddProductToCart")
    public ResponseEntity<String>  addProductToCart (@RequestParam(value = "id") Long ProductID) {
        if (serviceImplementation.addProduct(ProductID)) {
            return ResponseEntity.status(HttpStatus.OK).body("Done") ;
        }else {
            return ResponseEntity.status(HttpStatus.OK).body("is not available product") ;
        }
    }
    @GetMapping("AddOrderToCart")
    public ResponseEntity<String>  addOrderToCart (@RequestParam(value = "id") Long OrderID) {
        if (serviceImplementation.addOrder(OrderID)) {
            return ResponseEntity.status(HttpStatus.OK).body("Done") ;
        }else {
            return ResponseEntity.status(HttpStatus.OK).body("is not available product") ;
        }
    }
    @GetMapping("PayOrder")
    public ResponseEntity<String> payOrder (@RequestParam (value = "id") Long OrderId) {
        serviceImplementation.payOrder(OrderId);
        return ResponseEntity.status(HttpStatus.OK).body("Done") ;
    }

    // add balance end point
}

