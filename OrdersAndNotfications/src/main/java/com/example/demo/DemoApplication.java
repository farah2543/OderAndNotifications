package com.example.demo;

import com.example.demo.model.*;
import com.example.demo.service.System.Message.Message;
import com.example.demo.service.System.Message.ShipmentMessage;
import com.example.demo.service.System.OrderManagerAndCart.Cart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		// convert to shipping
		// deduction main price and fees
		// order cancellation
		// user add balance
		// headed to near-by locations,
		// login and register using auth not implemented in the service
		// Stat



//		UserAccount user1 = new UserAccount(13L ,
//				"test" ,
//				"123546" , new Cart(),"eslam" ,  "01157228162" , "el dokki" ,
//				Lang.English , "esla889900@gmail.com") ;
//		UserAccount user2 = new UserAccount( 12L ,
//				"test2" ,
//				"123546" , new Cart() , "maro" ,  "0123456789" , "el dokki" ,
//				Lang.English , "maro312@gmail.com") ;
//		Product p1 = new Product(12L , 12.5 , "Test" , "Vendor1" , "Sweets" ) ;
//		Order o1 = new Order() ;
//		o1.addItem(p1);
//		o1.setUser(user1.getId());
//		o1.assignObservers() ;
//		Order o2 = new Order() ;
//		o2.addItem(o1);
//		o2.addItem(p1);
//		o2.assignObservers() ;
//		o2.setStatus(Status.Placed);
//		Order o1 = new Order() ;
//		Order o2 = new Order() ;
//		Order o3 = new Order() ;
//		o1.setUser(10L);
//		o2.setUser(20L);
//		o3.setUser(30L);
//		Product p1 = new Product(12L , 12.5  , "test" , "12" , "12" ) ;
//		o1.addItem(p1);
//		o2.addItem(o1);
//		o2.addItem(p1);
//		o3.addItem(o2);
//		System.out.println(o3.assignObservers()) ;
//		o3.setStatus(Status.Placed);

//		Message m = new ShipmentMessage() ;
//		Cart c = new Cart() ;
//		UserAccount u = new UserAccount(12L , "test" , "123456" , c , "eslam" , "test" , "test" , Lang.Arabic ) ;
//		m.PrepareMessage(u , 12L);
//		System.out.println(m.template.getTemplate()) ;
//		u.setPreferedLang(Lang.English);
//		m.PrepareMessage(u , 12L);
//		System.out.println(m.template.getTemplate());
	}
}
