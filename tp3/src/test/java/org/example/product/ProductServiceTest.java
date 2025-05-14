package org.example.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;

    private ProductService productService;

    @BeforeEach
    void setUp() {
        productService = new ProductService(productApiClient);
    }

    @Test
    void getProduct_ShouldReturnProduct_WhenApiCallIsSuccessful() throws ProductApiException {
        // Arrange
        String productId = "123";
        Product expectedProduct = new Product(productId, "Test Product", 99.99);
        when(productApiClient.getProduct(productId)).thenReturn(expectedProduct);

        // Act
        Product actualProduct = productService.getProduct(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void getProduct_ShouldThrowException_WhenApiCallFails() throws ProductApiException {
        // Arrange
        String productId = "123";
        when(productApiClient.getProduct(productId))
            .thenThrow(new ProductApiException("API call failed"));

        // Act & Assert
        assertThrows(ProductApiException.class, () -> productService.getProduct(productId));
        verify(productApiClient).getProduct(productId);
    }

    @Test
    void getProduct_ShouldThrowException_WhenProductIdIsNull() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> productService.getProduct(null));
        verifyNoInteractions(productApiClient);
    }

    @Test
    void getProduct_ShouldThrowException_WhenProductIdIsEmpty() {
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> productService.getProduct("  "));
        verifyNoInteractions(productApiClient);
    }
} 