package Main.Test;

import Main.Models.Coin;
import Main.Models.Product;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakePurchaseTest {
    VendingMachine vm = new VendingMachine();
    Product cola = Product.COLA;
    Coin quarter = Coin.QUARTER;

    @Test
    public void whenProductIsPurchasedWithExactChangeUpdateArray() {

        while (vm.totalCoins(vm.coins) < 1.00) {
            vm.coinAccepted(quarter);
        }
        assertEquals(1.00, vm.totalCoins(vm.coins));
        assertTrue(vm.coins.contains(quarter));

        vm.makePurchase(cola, vm.coins);
        assertEquals(0.0, vm.totalCoins(vm.coins));
        assertTrue(vm.coins.isEmpty());
        assertEquals(vm.coinReserve.get(vm.coinReserve.size() - 1), Coin.QUARTER);
    }
    @Test
    public void whenProductIsPurchasedWithExcessChangeUpdateCoinReturn() {

        while (vm.totalCoins(vm.coins) <= 1.00) {
            vm.coinAccepted(quarter);
        }
        assertEquals(1.25, vm.totalCoins(vm.coins));

        vm.makePurchase(cola, vm.coins);
        assertTrue(vm.coins.isEmpty());
        assertFalse(vm.totalCoins(vm.coinReturn) == 0);
        assertTrue(vm.coinReturn.contains(quarter));
        assertEquals(vm.coinReserve.get(vm.coinReserve.size() - 1), Coin.QUARTER);
    }
    @Test
    public void whenCoinReserveIsLowAskForExactChange() {
        vm.coinReserve.clear();
        vm.makePurchase(cola, vm.coins);
        assertEquals("EXACT CHANGE ONLY",vm.getDisplay());
    }
}