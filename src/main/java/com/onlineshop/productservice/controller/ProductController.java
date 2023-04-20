package com.onlineshop.productservice.controller;


import com.onlineshop.productservice.entity.Product;
import com.onlineshop.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        return productRepository.findById(id).get();
    }

    @GetMapping()
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/create-product")
    public Product createProduct(@RequestBody Product  product){
        return productRepository.save(product);
    }

}
