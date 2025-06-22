package com.example.service;

import com.example.model.Product;
import com.example.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    private static final Map<Integer, Product> PRODUCT_DB = new HashMap<>();

    static {
        PRODUCT_DB.put(1, new Product(1, "Laptop", 75000));
        PRODUCT_DB.put(2, new Product(2, "Phone", 25000));
    }

    public Product getProductById(int id) {
        if (!PRODUCT_DB.containsKey(id)) {
            throw new ProductNotFoundException("Product with ID " + id + " not found");
        }
        return PRODUCT_DB.get(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(PRODUCT_DB.values());
    }
}