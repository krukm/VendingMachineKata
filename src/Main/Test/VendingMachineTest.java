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
        assertEquals(false, vm.coinAccepted(penny));
        assertEquals(true, vm.coinAccepted(nickel));
    }
}