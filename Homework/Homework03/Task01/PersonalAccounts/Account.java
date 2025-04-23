package Homework03.Task01.PersonalAccounts;

public class Account {
    //attributes:
    public String owner;
    private double balance;
    protected int pin;
    String internalNote; //package-private (default)

    //constructor:
    public Account(String owner, double balance, int pin, String internalNote) {
        this.owner = owner;
        this.balance = balance;
        this.pin = pin;
        this.internalNote = internalNote;
    }
    public Account(String owner, double balance, int pin) { //I suppose not every account may need an internal note from the get-go
        this.owner = owner;
        this.balance = balance;
        this.pin = pin;
    }

    //methods (aka getter & setter in this case)
    //I left out the other getters and setters as only these were specified in the task. I guess the other ones aren't wanted.
    public void setPin(int pin) {
        this.pin = pin;
    }
    public double getBalance() {
        return balance;
    }
}
