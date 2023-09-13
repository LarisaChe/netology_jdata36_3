package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.repository.ProductRepository;

import java.sql.SQLException;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public String getProducts(String name) throws SQLException {
        return repository.getProducts(name);
    }

    public String getCustomes() throws SQLException {
        return repository.getCustomes();
    }
}
