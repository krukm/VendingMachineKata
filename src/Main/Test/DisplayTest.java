package Main.Test;

import Main.Models.Coin;
import Main.Models.Product;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    VendingMachine vm = new VendingMachine();

    Coin nickel = Coin.NICKEL;
    Coin dime = Coin.DIME;
    Coin quarter = Coin.QUARTER;

    Product cola = Product.COLA;

    @Test
    public void whenCoinsAreAddedCheckForDisplayUpdate() {

        assertEquals("INSERT COIN", vm.getDisplay());
        vm.coinAccepted(dime);
        assertEquals("0.10", vm.getDisplay());

        vm.coinAccepted(quarter);
        vm.coinAccepted(quarter);
        vm.coinAccepted(dime);
        vm.coinAccepted(nickel);

        assertEquals("0.75", vm.getDisplay());

        vm.makePurchase(cola, vm.coins);
        assertEquals("PRICE = 1.00", vm.getDisplay());

        vm.coinAccepted(quarter);
        vm.makePurchase(cola, vm.coins);
        assertEquals("INSERT COIN", vm.getDisplay());

        vm.coinReserve.clear();
        assertTrue(vm.exactChangeNeeded());
        assertEquals("EXACT CHANGE ONLY", vm.getDisplay());
    }
    @Test
    public void whenProductIsOutOfStockDisplaySoldOut() {
        vm.inventory.clear();
        while (vm.totalCoins(vm.coins) <= 1.00) {
            vm.coinAccepted(quarter);
        }
        vm.makePurchase(cola, vm.coins);
        assertEquals("INSERT COIN", vm.getDisplay());
    }
    @Test()
    public void afterPurchaseCompleteOrWhenSoldOutResetDisplay() {
        while (vm.totalCoins(vm.coins) <= 1.00) {
            vm.coinAccepted(quarter);
        }
        vm.makePurchase(cola, vm.coins);
        //need a way to test getDisplay() before sleep
        assertEquals("INSERT COIN", vm.getDisplay());

        vm.inventory.clear();
        while (vm.totalCoins(vm.coins) <= 1.00) {
            vm.coinAccepted(quarter);
        }
        vm.makePurchase(cola, vm.coins);
        //need a way to test getDisplay() before sleep
        assertEquals("INSERT COIN", vm.getDisplay());
    }
}