package org.example.product;

public interface ProductApiClient {
    Product getProduct(String productId) throws ProductApiException;
}

class ProductApiException extends Exception {
    public ProductApiException(String message) {
        super(message);
    }

    public ProductApiException(String message, Throwable cause) {
        super(message, cause);
    }
} 