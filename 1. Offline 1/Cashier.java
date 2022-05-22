public class Cashier extends Employee {
    Cashier(String username, Bank bank) {
        super(username, "Cashier", bank);
    }

    @Override
    public void ApproveLoan() {
        System.out.println("You don't have permission for this operation.");
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
