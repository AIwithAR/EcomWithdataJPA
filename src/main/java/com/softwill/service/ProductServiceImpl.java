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
}
