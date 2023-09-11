package ru.netology.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.service.ProductService;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public String getProducts(@RequestParam("name") String name) throws SQLException {
        return service.getProducts(name);
    }

    /*@GetMapping("/cc")
    public String getCustomers() throws SQLException {
        return service.getCustomes();
    }*/
}
