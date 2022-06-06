package mortytheplatypus.Employees;

import mortytheplatypus.Accounts.Account;
import mortytheplatypus.Bank;

import java.util.ArrayList;

public abstract class Employee {
    //member variables
    private String username;
    private String type;
    protected Bank bank;

    Employee(String username, String type, Bank bank) {
        this.username = username;
        this.type = type;
        this.bank = bank;
    }

    public void Lookup(String username) {
        ArrayList<Account> accounts = bank.getAccounts();
        boolean noUserFound = true;

        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                System.out.println(username + "'s current Balance " + account.getBalance() +
                        "$, loan" + account.getLoan() + "$");
                noUserFound = false;
            }
        }

        if (noUserFound) {
            System.out.println("No user found by that name!");
        }

    }
    public abstract void ApproveLoan();
    public abstract void ChangeInterestRate(String accountType, double newRate);
    public abstract void SeeInternalFund();

    public String getUsername() {
        return username;
    }
}
