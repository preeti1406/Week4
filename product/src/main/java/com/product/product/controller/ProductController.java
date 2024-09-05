package com.product.product.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.product.product.model.product;
import com.product.product.service.ProductService;
import com.verizon.exception.ProductNotFoundException;

@RestController
public class ProductController {
	
	@Autowired 
	ProductService productService;

	@PostMapping("/product")
	public String addProduct(@RequestBody product p1)
	{
		String po=productService.addProduct(p1);
		return po;
	}
	
	@GetMapping("/product")
	public List<product> getProduct()
	{
		return productService.displayProduct();
	}
	
	// 3. Get a product by ID
    @GetMapping("product/{id}")
    public product getProductById(@PathVariable Integer id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    
    // 4. Get all products between a price range
    @GetMapping("product/price-range")
    public List<product> getProductsBetweenPrice(@RequestParam Integer low, @RequestParam Integer high) {
        return productService.getAllProductsBetweenPrice(low, high);
    }
    
	@PutMapping("/product/{pid}")
	public product updateProduct(@PathVariable Integer pid,@RequestBody product p1)
	{
		return productService.updateProduct(pid,p1);
	}
	@DeleteMapping("/product/{pid}")
	public String delProduct(@PathVariable Integer pid)
	{
		return productService.deleteProduct(pid);
	}
	
}
