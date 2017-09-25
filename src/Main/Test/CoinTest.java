package Main.Test;

import Main.Models.Coin;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoinTest {
    Coin penny = Coin.PENNY;
    Coin nickel = Coin.NICKEL;
    Coin dime = Coin.DIME;
    Coin quarter = Coin.QUARTER;
    @Test
    public void whenACoinIsSelectedGetCoinWeight(){
        assertEquals(2.500, penny.weight);
        assertEquals(5.000, nickel.weight);
        assertEquals(2.268, dime.weight);
        assertEquals(5.670, quarter.weight);
    }
    @Test
    public void whenACoinIsSelectedGetCoinDiameter() {
        assertEquals(0.750, penny.diameter);
        assertEquals(0.835, nickel.diameter);
        assertEquals(0.705, dime.diameter);
        assertEquals(0.955, quarter.diameter);
    }
}