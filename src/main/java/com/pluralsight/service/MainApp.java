package com.pluralsight.service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.pluralsight.dao.ProductDAO;
import com.pluralsight.model.Product;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ProductDAO productDao = context.getBean(ProductDAO.class);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    Main Menu:
                    1. List Products
                    2. Add Product
                    0. Exit
                    Enter your choice:\s""");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Listing Products:");
                    productDao.getAll().forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("""
                            Enter Product Details...
                            
                            Product ID:\s""");
                    int productId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Price: ");
                    double price = scanner.nextDouble();
                    Product newProduct = new Product(productId, productName, category, price);
                    productDao.add(newProduct);
                    System.out.println("Product added successfully!");
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}

