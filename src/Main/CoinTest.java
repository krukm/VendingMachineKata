package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {
    @Test
    public void whenPennyIsSelectedGetPennyWeight(){
        Coin penny  = Coin.PENNY;
        assertEquals(2.500, penny.weight);
    }
    @Test
    public void whenPennyIsSelectedGetPennyDiameter() {
        Coin penny = Coin.PENNY;
        assertEquals(0.750, penny.diameter);
    }
}