package com.example;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProductIO {

    public static Product getProduct(String code, String productPath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(productPath));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String productCode = parts[0].trim();
                    String description = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());

                    if (productCode.equalsIgnoreCase(code)) {
                        return new Product(productCode, description, price);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Nếu không tìm thấy thì trả về sản phẩm mặc định hoặc null
        return null;
    }
}