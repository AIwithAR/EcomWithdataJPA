package com.softwill.service;

import com.softwill.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAllProducts();


    List<Product> findByName(String name);
    List<Product> findByPriceLessThan(double price);
    List<Product> findByDescription(String keyword);
    List<Product> search(String name, Double price, String keyword);

}
