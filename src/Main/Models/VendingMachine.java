package Main.Models;

public class VendingMachine {

    public boolean coinAccepted(Coin coin) {
        switch(coin) {
            case PENNY:
                return false;
            case NICKEL:
                return true;
            case DIME:
                return true;
            case QUARTER:
                return true;
        }
        if (coinAccepted(coin)) return true;
        else return false;
    }
}
