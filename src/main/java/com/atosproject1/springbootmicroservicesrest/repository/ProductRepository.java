package com.atosproject1.springbootmicroservicesrest.repository;

import com.atosproject1.springbootmicroservicesrest.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
