package com.softwill.controller;


import com.softwill.model.Product;
import com.softwill.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){

        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double price,
            @RequestParam(required = false) String description){
        if(name ==null && price !=null && description ==null){

            return productService.findByPriceLessThan(price);

        }
        return productService.search(name,price, description);
    }

    @GetMapping("/searchByName")
    public List<Product> getProductByName(@RequestParam String name){
        return productService.findByName(name);

    }

    @GetMapping("/searchByDescription")
    public  List<Product> getProductByDescription(@RequestParam String keyword){
        return productService.findByDescription(keyword);
    }



}
