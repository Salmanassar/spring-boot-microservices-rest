package com.atosproject1.springbootmicroservicesrest;

import com.atosproject1.springbootmicroservicesrest.model.Product;
import com.atosproject1.springbootmicroservicesrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootMicroservicesRestApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMicroservicesRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("Monitor", "Electronics"));
        productRepository.save(new Product("Blanket", "Household"));
        productRepository.save(new Product( "Laptop", "Electronics"));
        productRepository.save(new Product( "Shirt", "Fashion"));
        productRepository.save(new Product( "Pens", "School"));

    }
}
