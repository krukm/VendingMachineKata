package Main.Models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendingMachine {

    Display display = new Display();

    public VendingMachine() {
        stockInventory();
        stockCoins();
        display.setMessage("INSERT COIN");
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


    public String getDisplay() {
        return display.getMessage();
    }
    public void makePurchase(Product product, ArrayList<Coin> coins) {
        if(totalCoins(coins) == product.price) {
            for(Coin c : coins) {
                coinReserve.add(c);
            }
            coins.clear();
            display.setMessage("THANK YOU");
        } else if (totalCoins(coins) > product.price) {
            makeChange((int)((totalCoins(coins) - product.price)  * 100));
            for(Coin c : coins) {
                coinReserve.add(c);
            }
            coins.clear();
            display.setMessage("THANK YOU");
        } else if (totalCoins(coins) < product.price) {
            display.setMessage("PRICE = " + decimalFormat.format(product.price));
        }
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
                display.setMessage(decimalFormat.format(totalCoins(coins)));
                return true;
            case DIME:
                coins.add(dime);
                display.setMessage(decimalFormat.format(totalCoins(coins)));
                return true;
            case QUARTER:
                coins.add(quarter);
                display.setMessage(decimalFormat.format(totalCoins(coins)));
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
            coinReserve.remove(quarter);
            quarters --;
        }
        while(dimes > 0) {
            coinReturn.add(dime);
            coinReserve.remove(dime);
            dimes --;
        }
        while(nickels > 0) {
            coinReturn.add(nickel);
            coinReserve.remove(nickel);
            nickels --;
        }
    }

    public Boolean exactChangeNeeded() {
        if(totalCoins(coinReserve) < 2.00) {
            display.setMessage("EXACT CHANGE ONLY");
            return true;
        }
        return false;
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
            coinReserve.add(quarter);
            coinReserve.add(dime);
            coinReserve.add(nickel);
        }
    }
}
