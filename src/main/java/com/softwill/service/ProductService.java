package com.softwill.service;

import com.softwill.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getAllProducts();
}
