package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Product;

import com.example.demo.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController

@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productrepository;
    @PostMapping("add")
    public ResponseEntity<?> addProduct(@RequestBody Product product)
    {
        Product save = productrepository.save(product);
        return ResponseEntity.ok(save);
    }
    @GetMapping("show")
    public ResponseEntity<?> getproduct()
    {
        return ResponseEntity.ok(this.productrepository.findAll());
    }
}
