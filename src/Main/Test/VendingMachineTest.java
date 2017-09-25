package Main.Test;

import Main.Models.Coin;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    @Test
    public void checkForValidCoin() {
        VendingMachine vm = new VendingMachine();

        Coin penny = Coin.PENNY;
        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        assertEquals(false, vm.coinAccepted(penny));
        assertEquals(true, vm.coinAccepted(nickel));
        assertEquals(true, vm.coinAccepted(dime));
        assertEquals(true, vm.coinAccepted(quarter));

        assertEquals(true, vm.coinReturn.contains(penny));
        assertEquals(true, vm.coins.contains(nickel));
        assertEquals(true, vm.coins.contains(dime));
        assertEquals(true, vm.coins.contains(quarter));

        assertEquals(false, vm.coinReturn.contains(nickel));
        assertEquals(false, vm.coinReturn.contains(dime));
        assertEquals(false, vm.coinReturn.contains(quarter));
        assertEquals(false, vm.coins.contains(penny));
    }
}