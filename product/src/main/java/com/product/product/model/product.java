package com.product.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class product {
	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	int product_Id;
String product_name;
int price;

public product()
{
	
}
public int getProduct_id() {
	return product_Id;
}
public void setProduct_id(int product_id) {
	this.product_Id = product_id;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public product(int product_id, String product_name, int price) {
	super();
	this.product_Id = product_id;
	this.product_name = product_name;
	this.price = price;
}
@Override
public String toString() {
	return "product [product_Id=" + product_Id + ", product_name=" + product_name + ", price=" + price + "]";
}


}

