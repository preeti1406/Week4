package com.product.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.product.model.product;

@Repository
public interface ProductDao extends JpaRepository<product,Integer>  {
	 @Query("SELECT p FROM product p WHERE p.price BETWEEN ?1 AND ?2")
	    List<product> findProductsByPriceBetween(Integer low, Integer high);
}
