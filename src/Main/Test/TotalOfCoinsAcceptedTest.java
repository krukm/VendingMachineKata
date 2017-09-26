package Main.Test;

import Main.Models.Coin;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TotalOfCoinsAcceptedTest {
    @Test
    public void whenCoinsAreAddedCheckArrayForCoinTotal() {
        VendingMachine vm = new VendingMachine();

        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        vm.coins.add(nickel);
        assertEquals(0.05, vm.totalCoins(vm.coins));
        vm.coins.add(dime);
        assertEquals(0.15, vm.totalCoins(vm.coins));
        vm.coins.add(quarter);
        assertEquals(0.40, vm.totalCoins(vm.coins));
    }
}