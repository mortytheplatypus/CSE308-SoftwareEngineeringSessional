package mortytheplatypus;

import mortytheplatypus.Accounts.Account;

import java.util.ArrayList;

public class Bank {
    private double[] interestRates = {0.1, 0.05, 0.15};

    private ArrayList<Account> accounts;
    private ArrayList<Account> loanRequests;
    private int year;
    private double internalFund;

    Bank() {
        accounts = new ArrayList<>();
        loanRequests = new ArrayList<>();
        internalFund = 1000000.0;
        year = 0;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public int getYear() {
        return year;
    }

    public double getInternalFund() {
        return internalFund;
    }

    public void DecreaseInternalFund(double amount) {
        internalFund -= amount;
    }

    public void IncreaseYear() {
        year++;
        System.out.println("1 year passed");

        //decrease loans
        for (Account account : accounts) {
            int typeIndex = account.getTypeIndex();
            account.DecreaseLoan(account.getLoan()*0.1);
            if (typeIndex == 3) {
                account.DecreaseBalance(500 < account.getBalance() ? 500 : account.getBalance());
                continue;
            }
            account.IncreaseBalance(account.getBalance()*interestRates[typeIndex]);
            account.DecreaseBalance(500 < account.getBalance() ? 500 : account.getBalance());
        }
    }

    Account CheckIfAccountExists(String username) {
        for (Account account : accounts) {
            if (account.getUsername().equalsIgnoreCase(username)) {
                return account;
            }
        }
        return null;
    }

    public boolean CheckIfValidLoanRequest(double amount) {
        if (amount < internalFund) {
            return true;
        }
        return false;
    }

    public ArrayList<Account> getLoanRequests() {
        return loanRequests;
    }

    boolean CheckIfLoanRequestsPending() {
        return !loanRequests.isEmpty();
    }

    public void AddAccount(Account account) {
        accounts.add(account);
    }

    public void AddLoanRequest(Account account) {
        loanRequests.add(account);
    }

    public void ChangeInterestRates(int index, double newRate) {
        this.interestRates[index] = newRate;
    }

}
