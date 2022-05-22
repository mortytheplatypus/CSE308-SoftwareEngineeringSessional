import java.util.Scanner;

public class Main {
    private static final int ACCOUNT = 1;
    private static final int EMPLOYEE = 2;
    private static final int NOONE = -1;

    public static void main(String[] args) {
        Bank bank = new Bank();
        System.out.println("Bank Created; MD, S1, S2, C1, C2, C3, C4, C5 created");

        Account account = null;
        Employee employee = null;
        int whoIsActiveStatus = NOONE;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = scanner.nextLine();
            String[] command = line.split(" ");

            if (whoIsActiveStatus == NOONE) {
                if (command[0].equalsIgnoreCase("Create")) {
                    if (command[2].equalsIgnoreCase("Savings")) {
                        account = new SavingsAccount(command[1], command[2], Double.parseDouble(command[3]));
                    } else if (command[2].equalsIgnoreCase("Student")) {
                        account = new StudentAccount(command[1], command[2], Double.parseDouble(command[3]));
                    } else if (command[2].equalsIgnoreCase("Fixed")) {
                        account = new FixedDepositAccount(command[1], command[2], Double.parseDouble(command[3]));
                    } else if (command[2].equalsIgnoreCase("Loan")) {
                        account = new LoanAccount(command[1], command[2], Double.parseDouble(command[3]));
                    }

                    bank.AddAccount(account);
                    whoIsActiveStatus = ACCOUNT;
                } else if (command[0].equalsIgnoreCase("Open")) {
                    //
                } else if (command[0].equalsIgnoreCase("INC")) {
                    bank.IncreaseYear();
                }
            } else if (whoIsActiveStatus == ACCOUNT) {
                if (command[0].equalsIgnoreCase("Query")) {
                    account.Query();
                } else if (command[0].equalsIgnoreCase("Withdraw")) {
                    account.Withdraw(Double.parseDouble(command[1]), bank.getYear());
                } else if (command[0].equalsIgnoreCase("Deposit")) {
                    account.Deposit(Double.parseDouble(command[1]));
                } else if (command[0].equalsIgnoreCase("Request")) {
                    account.RequestLoan(Double.parseDouble(command[1]));
                } else if (command[0].equalsIgnoreCase("Close")) {
                    whoIsActiveStatus = NOONE;
                    account.MakeInactive();
                }
            } else if (whoIsActiveStatus == EMPLOYEE) {
                if (command[0].equalsIgnoreCase("Lookup")) {
                    employee.Lookup(command[1]);
                } else if (command[0].equalsIgnoreCase("Approve")) {
                    employee.ApproveLoan();
                } else if (command[0].equalsIgnoreCase("Change")) {
                    employee.ChangeInterestRate(command[1], Double.parseDouble(command[2]));
                } else if (command[0].equalsIgnoreCase("See")) {
                    employee.SeeInternalFund();
                } else if (command[0].equalsIgnoreCase("Close")) {
                    whoIsActiveStatus = NOONE;
                    employee.MakeInactive();
                }
            }
        }
    }
}
