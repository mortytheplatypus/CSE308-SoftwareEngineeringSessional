package mortytheplatypus.Employees;

import mortytheplatypus.Accounts.Account;
import mortytheplatypus.Bank;

import java.util.ArrayList;

public class MD extends Employee {

    public MD(String username, Bank bank) {
        super(username, "MD", bank);
    }

    @Override
    public void ApproveLoan() {
        ArrayList<Account> loanRequests = bank.getLoanRequests();

        for (Account account : loanRequests) {
            boolean validity = bank.CheckIfValidLoanRequest(account.getLoanRequestAmount());

            if (validity) {
                System.out.println("Loan for " + account.getUsername() + " approved");
                bank.DecreaseInternalFund(account.getLoanRequestAmount());
                account.IncreaseBalance(account.getLoanRequestAmount());
                account.IncreaseLoan(account.getLoanRequestAmount());
            } else {
                System.out.println("Loan for " + account.getUsername() + " declined");
            }
        }
    }

    @Override
    public void ChangeInterestRate(String accountType, double newRate) {
        int index=-1;
        if (accountType.equalsIgnoreCase("Savings")) index = 0;
        else if (accountType.equalsIgnoreCase("Student")) index = 1;
        else if (accountType.equalsIgnoreCase("Fixed")) index = 2;

        if (index==-1) {
            System.out.println("Invalid request!");
            return;
        }

        bank.ChangeInterestRates(index, newRate);
    }

    @Override
    public void SeeInternalFund() {
        System.out.println("Current internal fund " + bank.getInternalFund() + "$");
    }
}
