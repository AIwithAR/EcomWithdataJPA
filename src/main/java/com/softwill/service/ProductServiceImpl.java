package com.softwill.service;


import com.softwill.dao.ProductDao;
import com.softwill.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService{

    @Autowired
    private ProductDao productDao;


    @Override
    public Product saveProduct(Product product) {
        return productDao.save(product);  //Proxy ProdcutDaoImpl
    }

    @Override
    public List<Product> getAllProducts() {
        return productDao.findAll();

    }

    // ------------------------------------------------------------

    @Override
    public List<Product> findByName(String name) {
        return productDao.findByNameIgnoreCase(name);
    }

    @Override
    public List<Product> findByPriceLessThan(double price) {
        return productDao.findByPriceLessThan(price);
    }

    @Override
    public List<Product> findByDescription(String keyword) {
        return productDao.findByDescriptionContainingIgnoreCase(keyword);
    }

    @Override
    public List<Product> search(String name, Double price, String keyword) {
        return productDao.searchProducts(name,price,keyword);
    }


}

