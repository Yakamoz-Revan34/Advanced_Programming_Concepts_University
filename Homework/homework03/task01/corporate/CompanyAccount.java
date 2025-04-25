package homework03.task01.corporate;

import homework03.task01.bank.Account;

public class CompanyAccount extends Account {
    public void testAccess() {
        System.out.println(owner);         //public - accessible
        // System.out.println(balance);    //private - not accessible
        System.out.println(pin);           //protected - accessible in subclass
        // System.out.println(internalNote); //package-private - not accessible from outside package
    }
}