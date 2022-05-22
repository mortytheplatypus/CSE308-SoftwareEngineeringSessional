import java.util.ArrayList;

public class Officer extends Employee {
    Officer(String username, Bank bank) {
        super(username, "Officer", bank);
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
        System.out.println("You don't have permission for this operation.");
    }

    @Override
    public void SeeInternalFund() {
        System.out.println("You don't have permission for this operation.");
    }
}
