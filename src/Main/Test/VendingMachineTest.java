package Main.Test;

import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendingMachineTest {
    @Test
    public void whenAVendingMachineIsInstantiatedCheckThatInventoryAndCoinReserveAreAdded() {
        VendingMachine vm = new VendingMachine();

        assertEquals(30, vm.inventory.size());
        assertEquals(30, vm.coinReserve.size());
    }
}