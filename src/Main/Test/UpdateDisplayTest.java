package Main.Test;

import Main.Models.Coin;
import Main.Models.Product;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UpdateDisplayTest {
    @Test
    public void whenCoinsAreAddedCheckForDisplayUpdate() {
        VendingMachine vm = new VendingMachine();

        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        Product cola = Product.COLA;

        assertEquals("INSERT COIN", vm.updateDisplay());
        vm.coins.add(dime);
        assertEquals("0.10", vm.updateDisplay());

        vm.coins.add(quarter);
        vm.coins.add(quarter);
        vm.coins.add(dime);
        vm.coins.add(nickel);

        assertEquals("0.75", vm.updateDisplay());

        vm.makePurchase(cola);
        assertEquals("PRICE = 1.00", vm.updateDisplay());

        vm.coins.add(quarter);
        vm.makePurchase(cola);
        assertEquals("THANK YOU", vm.updateDisplay());
    }
}