package Main.Models;

import java.util.ArrayList;

public class VendingMachine {

    public ArrayList<Coin> coins = new ArrayList<>();
    public ArrayList<Coin> coinReturn = new ArrayList<>();

    Coin penny = Coin.PENNY;
    Coin nickel = Coin.NICKEL;
    Coin dime = Coin.DIME;
    Coin quarter = Coin.QUARTER;

    public boolean coinAccepted(Coin coin) {
        switch(coin) {
            case PENNY:
                coinReturn.add(penny);
                return false;
            case NICKEL:
                coins.add(nickel);
                return true;
            case DIME:
                coins.add(dime);
                return true;
            case QUARTER:
                coins.add(quarter);
                return true;
        }
        if (coinAccepted(coin)) return true;
        else return false;
    }
}
