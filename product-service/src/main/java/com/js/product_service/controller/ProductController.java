package com.js.product_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Value("${product.name}")
	private String productFromConfig;
	
	@GetMapping("/productfromconfig")
	public ResponseEntity<String> getProductFromConfig(){
		return ResponseEntity.ok("Config Repo has " + productFromConfig);
	}

	@GetMapping("/{id}")
	public String getProduct(@PathVariable("id") String id){
		return "product from product-service " + id;
	}
}
