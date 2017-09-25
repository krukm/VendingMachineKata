package Main;

public enum Coin {
    PENNY(2.500, 0.750), NICKEL(5.000, 0.835), DIME(2.268, 0.705), QUARTER(5.670, 0.955);
    public double weight, diameter;
    Coin(double weight, double diameter) {
        this.weight = weight;
        this.diameter = diameter;
    }
}