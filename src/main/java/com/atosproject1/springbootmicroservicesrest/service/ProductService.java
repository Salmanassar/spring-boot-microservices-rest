package com.atosproject1.springbootmicroservicesrest.service;

import com.atosproject1.springbootmicroservicesrest.model.Product;
import com.atosproject1.springbootmicroservicesrest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable("products")
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Cacheable(value = "product", key = "#p0")
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    //    perform a cache eviction on the cache name "products"
    //    allEntries = true visibility in the response next time when we get all products
    @CacheEvict(value = "products", allEntries = true)
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Caching(evict = {
            @CacheEvict(value = "product", key = "#p0"),
            @CacheEvict(value = "products", allEntries = true)})
    public void updateProduct(Long id, Product product) {
        if (productRepository.findById(id).isPresent()) {
            productRepository.save(product);
        }
    }

    @Caching(evict = {
            @CacheEvict(value = "product", key = "#p0"),
            @CacheEvict(value = "products", allEntries = true)})
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
