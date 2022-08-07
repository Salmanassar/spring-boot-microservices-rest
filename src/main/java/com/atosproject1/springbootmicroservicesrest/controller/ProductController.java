package com.atosproject1.springbootmicroservicesrest.controller;

import com.atosproject1.springbootmicroservicesrest.exception.ProductNotFoundException;
import com.atosproject1.springbootmicroservicesrest.model.Product;
import com.atosproject1.springbootmicroservicesrest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/products/{pId}")
    public Product getProductById(@PathVariable("pId") Long id) {
        return productService.getProductById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/products/{pId}")
    public void updateProduct(@RequestBody Product product, @PathVariable("pId") Long id) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{pId}")
    public void deleteProduct(@PathVariable("pId") Long id) {
        productService.deleteProduct(id);
    }
}
