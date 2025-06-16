package com.js.order_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.js.order_service.communication.AccountClient;
import com.js.order_service.communication.ProductClient;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Value("${order.name}")
	private String orderCategory;
	
	private final ProductClient productClient;
	private final AccountClient accountClient;

	public OrderController(ProductClient productClient, AccountClient accountClient) {
		this.productClient = productClient;
		this.accountClient = accountClient;
	}
	
	@GetMapping("/orderfromconfig")
	public ResponseEntity<String> getOrderFromConfig(){
		return ResponseEntity.ok("Config Repo has " + orderCategory);
	}

	@GetMapping("/{id}")
	public ResponseEntity<String> getOrder(@PathVariable String id){
		String product = productClient.getProduct("101");
		String account = accountClient.getAccount("201");
		return ResponseEntity.ok("Order id" + id + "Product id: " + product + "Account id:" + account);
	}
}
