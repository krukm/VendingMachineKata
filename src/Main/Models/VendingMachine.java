package Main.Models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class VendingMachine {

    private Display display = new Display();
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

    private Coin penny = Coin.PENNY;
    private Coin nickel = Coin.NICKEL;
    private Coin dime = Coin.DIME;
    private Coin quarter = Coin.QUARTER;
    private Product cola = Product.COLA;
    private Product chips = Product.CHIPS;
    private Product candy = Product.CANDY;

    public String getDisplay() {
        exactChangeNeeded();
        return display.getMessage();
    }
    public void makePurchase(Product product, ArrayList<Coin> coins) {
        String message[] = {"THANK YOU", "INSERT COIN"};
        if (!outOfStock(product)) {
            if (totalCoins(coins) == product.price) {
                coinReserve.addAll(coins);
                coins.clear();
                inventory.remove(product);
                for (int i = 0; i < message.length; i++) {
                    try {
                        Thread.sleep(5000);
                        display.setMessage(message[i]);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (totalCoins(coins) > product.price) {
                makeChange((int) ((totalCoins(coins) - product.price) * 100));
                coinReserve.addAll(coins);
                inventory.remove(product);
                coins.clear();
                for (int i = 0; i < message.length; i++) {
                    try {
                        Thread.sleep(5000);
                        display.setMessage(message[i]);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            } else if (totalCoins(coins) < product.price) {
                display.setMessage("PRICE = " + decimalFormat.format(product.price));
            }
        }
    }
    public double totalCoins(ArrayList<Coin> coins) {
        double total = 0.0;
        for(Coin change : coins) {
            total = total + change.value;
        }
        return Double.parseDouble(decimalFormat.format(total));
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
    public void coinReturnActivated() {
        coinReturn.addAll(coins);
        coins.clear();
        display.setMessage("INSERT COIN");
    }
    public boolean exactChangeNeeded() {
        if(!coinReserve.contains(quarter) || !coinReserve.contains(dime) || !coinReserve.contains(nickel)) {
            display.setMessage("EXACT CHANGE ONLY");
            return true;
        }
        return false;
    }
    private boolean outOfStock(Product product) {
        String message[] = {"OUT OF STOCK", "INSERT COIN"};
        if(!inventory.contains(product)) {
            for (int i = 0; i < message.length; i++) {
                try {
                    Thread.sleep(5000);
                    display.setMessage(message[i]);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
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