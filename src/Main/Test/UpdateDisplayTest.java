package Main.Test;

import Main.Models.Coin;
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

        vm.coins.add(dime);
        assertEquals(true,String.valueOf(vm.totalOfCoinsAccepted(vm.coins)) == vm.updateDisplay());
        assertEquals("0.10", vm.updateDisplay());

        vm.coins.add(quarter);
        vm.coins.add(quarter);
        vm.coins.add(dime);
        vm.coins.add(nickel);

        assertEquals("0.75", vm.updateDisplay());
        assertEquals(true, String.valueOf(vm.totalOfCoinsAccepted(vm.coins)) == vm.updateDisplay());
    }
}