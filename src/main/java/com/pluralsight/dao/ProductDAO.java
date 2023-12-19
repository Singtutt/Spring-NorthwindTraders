package com.pluralsight.dao;
import org.springframework.stereotype.Repository;
import com.pluralsight.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAO implements ProductInterface {
    private List<Product> products;
    public ProductDAO() {
        products = new ArrayList<>();
        products.add(new Product(1, "Product1", "Category1", 20.00));
        products.add(new Product(1, "Product2", "Category2", 15.00));
        products.add(new Product(1, "Product3", "Category3", 5.00));
    }
    @Override
    public void add(Product product) {
        products.add(product);
    }
    @Override
    public List<Product> getAll() {
        return products;
    }
}
