package Main.Test;

import Main.Models.Coin;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    @Test
    public void checkForValidCoin() {
        VendingMachine vm = new VendingMachine();
        ArrayList<Coin> coins = new ArrayList<>();
        ArrayList<Coin> coinReturn = new ArrayList<>();

        Coin penny = Coin.PENNY;
        Coin nickel = Coin.NICKEL;
        Coin dime = Coin.DIME;
        Coin quarter = Coin.QUARTER;

        assertEquals(false, vm.coinAccepted(penny));
        assertEquals(coinReturn.contains(penny), vm.coinAccepted(penny));
        assertEquals(true, vm.coinAccepted(nickel));
        assertEquals(true, vm.coinAccepted(dime));
        assertEquals(true, vm.coinAccepted(quarter));
    }
}