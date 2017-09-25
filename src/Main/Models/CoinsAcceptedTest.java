package Main.Models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsAcceptedTest {
    @Test
    public void whenCoinsAreAddedCheckArrayForCoinTotal() {
        VendingMachine vm = new VendingMachine();

        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        vm.coins.add(nickel);
        assertEquals(0.05, vm.coinsAccepted(vm.coins));
        vm.coins.add(dime);
        assertEquals(0.15, vm.coinsAccepted(vm.coins));
        vm.coins.add(quarter);
        assertEquals(0.40, vm.coinsAccepted(vm.coins));
    }
}