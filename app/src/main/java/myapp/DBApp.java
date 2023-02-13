package myapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import myapp.config.DBConfig;
import myapp.model.Product;
import myapp.model.ProductRepository;
import myapp.service.ProductService;

public class DBApp {
    public static void main(String[] args) throws SQLException {
        // 1. 커넥션 가져오기
        Connection conn = DBConfig.getConnection();
        // 2. DAO를 메모리에 올리기
        ProductRepository productRepository = new ProductRepository(conn);
        // 3. SERVICE를 메모리에 올리기
        ProductService productService = new ProductService(productRepository, conn);

        List<Product> productList = productRepository.findAll();
        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }
}