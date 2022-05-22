import java.util.ArrayList;
import java.util.Stack;

public class MD extends Employee {

    MD(String username, Bank bank) {
        super(username, "MD", bank);
    }

    @Override
    public void ApproveLoan() {
        ArrayList<Account> loanRequests = bank.loanRequests;

        for (Account account : loanRequests) {
            boolean validity = bank.CheckIfValidLoanRequest(account.getLoanRequestAmount());

            if (validity) {
                System.out.println("Loan for " + account.getUsername() + " approved");
                bank.DecreaseInternalFund(account.getLoanRequestAmount());
            } else {
                System.out.println("Loan for " + account.getUsername() + " declined");
            }
        }
    }

    @Override
    public void ChangeInterestRate(String accountType, double newRate) {
        int index;
        if (accountType.equalsIgnoreCase("Savings")) index = 0;
        else if (accountType.equalsIgnoreCase("Student")) index = 1;
        else if (accountType.equalsIgnoreCase("Fixed")) index = 2;
        else index = -1;

        bank.interestRates[index] = newRate;
    }

    @Override
    public void SeeInternalFund() {
        System.out.println("Current internal fund" + bank.getInternalFund() + "$");
    }
}
