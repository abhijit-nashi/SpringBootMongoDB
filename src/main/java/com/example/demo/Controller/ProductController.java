package com.example.demo.Controller;


//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.Product;
import com.example.demo.Services.ProductServices;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductServices productservice;

    //@Autowired
    public ProductController(ProductServices productservice) {
        this.productservice = productservice;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productservice.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productservice.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productservice.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        productservice.updateProduct(id, updatedProduct);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productservice.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
