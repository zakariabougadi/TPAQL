package org.example.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    private OrderController orderController;

    @BeforeEach
    void setUp() {
        orderController = new OrderController(orderService);
    }

    @Test
    void createOrder_ShouldCallOrderService() {
        // Arrange
        Order order = new Order(1L, "John Doe", 100.0);

        // Act
        orderController.createOrder(order);

        // Assert
        verify(orderService).createOrder(order);
    }
} 