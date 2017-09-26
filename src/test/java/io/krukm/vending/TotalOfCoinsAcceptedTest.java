package io.krukm.vending;

import io.krukm.vending.model.Coin;
import io.krukm.vending.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalOfCoinsAcceptedTest {
    @Test
    public void whenCoinsAreAddedCheckArrayForCoinTotal() {
        VendingMachine vm = new VendingMachine();

        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        vm.coinAccepted(nickel);
        assertEquals(0.05, vm.totalCoins(vm.coins));
        vm.coinAccepted(dime);
        assertEquals(0.15, vm.totalCoins(vm.coins));
        vm.coinAccepted(quarter);
        assertEquals(0.40, vm.totalCoins(vm.coins));
    }
}
