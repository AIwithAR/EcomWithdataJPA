package com.softwill.dao;

import com.softwill.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Long> {

    List<Product> findByNameIgnoreCase(String name);

    List<Product> findByPriceLessThan(double price);
    //select * from product where price < 10000;

    List<Product> findByDescriptionContainingIgnoreCase(String keyword);
    // select * from product where Lower(description) like Lower (concat ('%', keyword, '%'));

    @Query("SELECT p FROM Product p WHERE" +
    "(:name IS NULL OR LOWER(p.name)=LOWER(:name)) AND" +
    "(:price IS NULL OR p.price < :price) AND " +
    "(:keyword IS NULL OR LOWER(p.description) LIKE LOWER(CONCAT ('%', :keyword, '%'))) ")
    List<Product> searchProducts(String name, Double price, String keyword);




}
