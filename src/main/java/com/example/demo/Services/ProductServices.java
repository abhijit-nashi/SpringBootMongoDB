package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Product;
import com.example.demo.Repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    private ProductRepository productrepository;

    @Autowired
    public void ProductService(ProductRepository productrepository) {
        this.productrepository = productrepository;
    }

    public List<Product> getAllProducts() {
        return productrepository.findAll();
    }

    public Optional<Product> getProductById(String id) {
        return productrepository.findById(id);
    }

    public Product addProduct(Product product) {
        return productrepository.save(product);
    }

    public void updateProduct(String id, Product updatedProduct) {
        productrepository.findById(id).ifPresent(existingProduct -> {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            productrepository.save(existingProduct);
        });
    }

    public void deleteProduct(String id) {
        productrepository.deleteById(id);
    }
}

