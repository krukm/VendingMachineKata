package io.krukm.vending;

import io.krukm.vending.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product cola = Product.COLA;
    Product chips = Product.CHIPS;
    Product candy = Product.CANDY;
    @Test
    public void whenAProductIsSelectedGetThePrice() {
        assertEquals(1.00, cola.price);
        assertEquals(0.50, chips.price);
        assertEquals(0.65, candy.price);
    }
}
