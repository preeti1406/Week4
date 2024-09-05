package com.product.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.product.dao.ProductDao;
import com.product.product.model.product;
import com.verizon.exception.ProductNotFoundException;

@Service 
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	
	public String addProduct(product p)
	{
		productDao.save(p);
		return "Added to database";
	}
	
	// 3. Get product by ID
    public product getProductById(Integer id) throws ProductNotFoundException {
        return productDao.findById(id)
            .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));
    }

    // 4. Get all products between a certain price range
    public List<product> getAllProductsBetweenPrice(Integer low, Integer high) {
        return productDao.findProductsByPriceBetween(low, high);
    }
	
	public List<product> displayProduct()
	{
		List<product> list=productDao.findAll();
		return list;
	}
	public product updateProduct(int pid,product p2)
	{
		product p3=productDao.findById(pid).get();
		if(p3!=null)
		{
			p3.setPrice(p2.getPrice());
			productDao.save(p2);
		}
		return productDao.findById(pid).get();
	}
	
	public String deleteProduct(int pid)
	{
		product p3=productDao.findById(pid).get();
		if(p3!=null)
		{
			productDao.deleteById(pid);
		}
		return "Deleted";
	}
}
