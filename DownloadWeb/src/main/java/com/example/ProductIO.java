package com.example;

import java.util.*;
import java.io.*;
import javax.servlet.ServletContext;

public class ProductIO {

    // Ví dụ đọc sản phẩm từ file text (mỗi dòng 1 sản phẩm: code|description|price)
    public static List<Product> getProducts(String filePath) {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 3) {
                    Product product = new Product();
                    product.setCode(parts[0]);
                    product.setDescription(parts[1]);
                    product.setPrice(Double.parseDouble(parts[2]));

                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return products;
    }

    // Lấy sản phẩm theo code
    public static Product getProduct(String productCode, String filePath) {
        List<Product> products = getProducts(filePath);

        for (Product p : products) {
            if (p.getCode().equals(productCode)) {
                return p;
            }
        }

        return null; // không tìm thấy
    }
}