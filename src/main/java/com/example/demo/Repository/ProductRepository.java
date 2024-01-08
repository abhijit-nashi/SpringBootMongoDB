package com.example.demo.Repository;




import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.Model.Product;



public interface ProductRepository extends MongoRepository<Product, String> {
    // Additional custom queries can be added here if needed
}

