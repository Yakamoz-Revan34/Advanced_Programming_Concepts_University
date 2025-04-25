package homework03.task01.bank;

public class Account {
    public String owner;
    private double balance;
    protected int pin;
    String internalNote; // package-private

    public double getBalance() {
        return balance;
    }

    public boolean changePin(int currentPin, int newPin) {
        if (this.pin == currentPin) {
            this.pin = newPin;
            return true;
        }
        return false;
    }
}
