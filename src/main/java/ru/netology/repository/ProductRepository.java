package ru.netology.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.model.Customer;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductRepository {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductRepository() {
    }

    public String getProducts(String name) throws SQLException {
        Map<String, String> params = new HashMap<>();
        params.put("paramName", name);
        Connection connection = dataSource.getConnection();
        List<String> products = namedParameterJdbcTemplate.query(read("query01.sql"), params, (resultSet, rowNum) -> {
            String product_name = resultSet.getString("product_name");
            return product_name;
        });
        //products.forEach(System.out::println);
        return products.toString();
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCustomes() throws SQLException {  //List<Customer>
        Connection connection = dataSource.getConnection();
        List<Customer> customers = jdbcTemplate.query("select * from customers", (resultSet, rowNum) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt("age");
            String phone_number = resultSet.getString("phone_number");
            return new Customer(id, name, surname, age, phone_number);
        });
        customers.forEach(System.out::println);
        return customers.toString();
    }
}
