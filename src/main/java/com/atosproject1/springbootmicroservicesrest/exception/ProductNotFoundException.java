package com.atosproject1.springbootmicroservicesrest.exception;

public class ProductNotFoundException extends RuntimeException {
    private static final Long serialVersionUID = 1L;

    public ProductNotFoundException(Long id) {
        super("The product with " + id + " can not be found");
    }
}
