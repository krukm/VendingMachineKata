package io.krukm.vending;

import io.krukm.vending.model.Coin;
import io.krukm.vending.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MakeChangeTest {
    @Test
    public void whenChangeIsDueAddToCoinReturn() {
        VendingMachine vm = new VendingMachine();
        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        vm.makeChange(15);
        assertTrue(vm.coinReturn.contains(dime) && vm.coinReturn.contains(nickel));

        vm.coinReturn.clear();
        vm.makeChange(65);
        assertTrue(vm.coinReturn.contains(nickel) && vm.coinReturn.contains(dime) && vm.coinReturn.contains(quarter));

        vm.coinReturn.clear();
        vm.makeChange(25);
        assertTrue(vm.coinReturn.contains(quarter));
    }
}
