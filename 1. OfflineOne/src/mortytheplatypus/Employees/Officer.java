package mortytheplatypus.Employees;

import mortytheplatypus.Accounts.Account;
import mortytheplatypus.Bank;

import java.util.ArrayList;

public class Officer extends Employee {
    public Officer(String username, Bank bank) {
        super(username, "Officer", bank);
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
        System.out.println("You don't have permission for this operation.");
    }

    @Override
    public void SeeInternalFund() {
        System.out.println("You don't have permission for this operation.");
    }
}
