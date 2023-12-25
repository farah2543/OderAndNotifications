package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.service.* ;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		Order o1 = new Order(12) ;
		Order o2 = new Order((13 ));
		Order o3 = new Order(14) ;
		Product p1 = new Product(15 , 12.5) ;
		Product p2 = new Product(16 , 17.5) ;
		o2.addItem(p1);
		o2.addItem(p2);
		o1.addItem(o2);
		o1.addItem(o3);
		o1.addItem(p1);
		o1.totalPrice() ;
		System.out.println(o1.getPrice());
		System.out.println(o2.getPrice());
		System.out.println(o3.getPrice());
	}
}
