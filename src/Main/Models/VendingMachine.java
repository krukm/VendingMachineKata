package Main.Models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendingMachine {

    public ArrayList<Coin> coins = new ArrayList<>();
    public ArrayList<Coin> coinReturn = new ArrayList<>();
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    Coin penny = Coin.PENNY;
    Coin nickel = Coin.NICKEL;
    Coin dime = Coin.DIME;
    Coin quarter = Coin.QUARTER;

    Boolean purchaseComplete = false;
    Boolean needMoreCoins = false;
    double currentProductPrice = 0.0;

    public void makePurchase(Product product) {
        if(totalOfCoinsAccepted(coins) == product.price) {
            coins.clear();
            purchaseComplete = true;
        } else if (totalOfCoinsAccepted(coins) > product.price) {
            double returnChange = product.price - totalOfCoinsAccepted(coins);
            coins.clear();
        } else {
            needMoreCoins = true;
            currentProductPrice = product.price;
        }
    }
    public String updateDisplay() {
        String s = "";

        if (purchaseComplete) {
            s = "THANK YOU";
         } else if(needMoreCoins) {
            s = "PRICE = " + decimalFormat.format(currentProductPrice);
        } else if (totalOfCoinsAccepted(coins) != 0.0) {
            s = decimalFormat.format(totalOfCoinsAccepted(coins));
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
    public void makeChange(int change) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;

        if (change > 0) {
            quarters = change / 25;
            dimes = (change % 25) / 10;
            nickels = ((change % 25) % 10) / 5;
            pennies = ((change % 25) % 10) % 5;
        }
        while(quarters > 0) {
            coinReturn.add(quarter);
            quarters --;
        }
        while(dimes > 0) {
            coinReturn.add(dime);
            dimes --;
        }
        while(nickels > 0) {
            coinReturn.add(nickel);
            nickels --;
        }
        while(pennies > 0) {
            coinReturn.add(penny);
            pennies --;
        }
    }
}
