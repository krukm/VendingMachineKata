package Main.Test;

import Main.Models.Coin;
import Main.Models.VendingMachine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinReturnTest {
    @Test
    public void whenCoinReturnIsActivatedReturnCoins() {
        VendingMachine vm = new VendingMachine();
        Coin dime = Coin.DIME;

        vm.coinAccepted(dime);
        vm.coinReturnActivated();
        assertTrue(vm.coinReturn.contains(dime));
    }
}