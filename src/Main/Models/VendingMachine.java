package Main.Models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendingMachine {

    public VendingMachine() {
        stockInventory();
        stockCoins();
    }

    public ArrayList<Coin> coins = new ArrayList<>();
    public ArrayList<Coin> coinReturn = new ArrayList<>();
    public ArrayList<Product> inventory = new ArrayList<>();
    public ArrayList<Coin> coinReserve = new ArrayList<>();
    private DecimalFormat decimalFormat = new DecimalFormat("0.00");

    Coin penny = Coin.PENNY;
    Coin nickel = Coin.NICKEL;
    Coin dime = Coin.DIME;
    Coin quarter = Coin.QUARTER;
    Product cola = Product.COLA;
    Product chips = Product.CHIPS;
    Product candy = Product.CANDY;

    Boolean purchaseComplete = false;
    Boolean needMoreCoins = false;
    double currentProductPrice = 0.0;

    public void makePurchase(Product product, ArrayList<Coin> coins) {
        if(totalCoins(coins) == product.price) {
            for(Coin c : coins) {
                coinReserve.add(c);
            }
            coins.clear();
            purchaseComplete = true;
        } else if (totalCoins(coins) > product.price) {
            makeChange((int)((totalCoins(coins) - product.price)  * 100));
            coins.clear();
            purchaseComplete = true;
        } else if (totalCoins(coins) < product.price) {
            needMoreCoins = true;
            currentProductPrice = product.price;
        }
    }
    public String updateDisplay() {
        String s = "";

        if (purchaseComplete) {
            s = "THANK YOU";
            needMoreCoins = false;
            currentProductPrice = 0.0;
         } else if(needMoreCoins) {
            s = "PRICE = " + decimalFormat.format(currentProductPrice);
        } else if (totalCoins(coins) != 0.0) {
            s = decimalFormat.format(totalCoins(coins));
        } else {
            s = "INSERT COIN";
        }
        return s;
    }

    public double totalCoins(ArrayList<Coin> coins) {
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

        if (change > 0) {
            quarters = change / 25;
            dimes = (change % 25) / 10;
            nickels = ((change % 25) % 10) / 5;
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
    }

    private void stockInventory() {
        for(int i = 0; i < 10; i++) {
            inventory.add(cola);
            inventory.add(candy);
            inventory.add(chips);
        }
    }
    private void stockCoins() {
        for(int i = 0; i < 10; i++) {
            coinReserve.add(nickel);
            coinReserve.add(dime);
            coinReserve.add(quarter);
        }
    }
}
