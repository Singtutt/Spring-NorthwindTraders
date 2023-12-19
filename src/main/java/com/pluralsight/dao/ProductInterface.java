package com.pluralsight.dao;

import com.pluralsight.model.Product;

import java.util.List;

public interface ProductInterface {
    void add(Product product);
    List<Product> getAll();
}
