import java.util.ArrayList;

public class MD extends Employee {

    MD(String username, Bank bank) {
        super(username, "MD", bank);
    }

    @Override
    public void ApproveLoan() {
        ArrayList<Account> accounts = bank.getAccounts();

        for (Account account : accounts) {
            if (account.getLoanRequestStatus() == PENDING) {
                System.out.println("Loan for " + account.getUsername() + " approved");
                bank.DecreaseInternalFund(account.getLoanRequestAmount());
                account.setLoanRequestStatus(NOTREQUESTED);
                account.setLoanRequestAmount(0);
            } else if (account.getLoanRequestStatus() == INVALID) {
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
