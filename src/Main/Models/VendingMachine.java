package Main.Models;

import java.util.ArrayList;

public class VendingMachine {

    public ArrayList<Coin> coins = new ArrayList<>();
    public ArrayList<Coin> coinReturn = new ArrayList<>();

    Coin penny = Coin.PENNY;
    Coin nickel = Coin.NICKEL;
    Coin dime = Coin.DIME;
    Coin quarter = Coin.QUARTER;


    public String updateDisplay() {
        String s = "";
        if (totalOfCoinsAccepted(coins) != 0.0) {
            s = String.valueOf(totalOfCoinsAccepted(coins));
        } else {
            s = "INSERT COIN";
        }
        return s;
    }

    public double totalOfCoinsAccepted(ArrayList<Coin> coins) {
        double total = 0;
        for(Coin change : coins) {
            total = total + change.value;
        }
        return total;
    }

    public boolean coinAccepted(Coin coin) {
        switch(coin) {
            case PENNY:
                coinReturn.add(penny);
                return false;
            case NICKEL:
                coins.add(nickel);
                updateDisplay();
                return true;
            case DIME:
                coins.add(dime);
                updateDisplay();
                return true;
            case QUARTER:
                coins.add(quarter);
                updateDisplay();
                return true;
        }
        if (coinAccepted(coin)) return true;
        else return false;
    }
}
