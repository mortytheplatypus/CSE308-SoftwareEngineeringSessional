package mortytheplatypus;

import mortytheplatypus.Accounts.*;
import mortytheplatypus.Employees.*;

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

            if (command[0].equalsIgnoreCase("EXIT")) {
                break;
            } if (whoIsActiveStatus == NOONE) {
                if (command[0].equalsIgnoreCase("Create")) {
                    if (command.length != 4) {
                        System.out.println("Bad request!");
                        continue;
                    }

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
                    if (command.length != 2) {
                        System.out.println("Bad request!");
                        continue;
                    }

                    if (command[1].equalsIgnoreCase("MD")) {
                        System.out.print(command[1] + " active");
                        if (bank.CheckIfLoanRequestsPending()) {
                            System.out.print(", there are loan approvals pending");
                        }
                        employee = new MD(command[1], bank);
                        whoIsActiveStatus = EMPLOYEE;
                    } else if (command[1].equalsIgnoreCase("S1") || command[1].equalsIgnoreCase("S2")) {
                        System.out.print(command[1] + " active");
                        if (bank.CheckIfLoanRequestsPending()) {
                            System.out.print(", there are loan approvals pending");
                        }
                        employee = new Officer(command[1], bank);
                        whoIsActiveStatus = EMPLOYEE;
                    } else if (command[1].equalsIgnoreCase("C1") || command[1].equalsIgnoreCase("C2") || command[1].equalsIgnoreCase("C3") || command[1].equalsIgnoreCase("C4") || command[1].equalsIgnoreCase("C5")) {
                        System.out.print(command[1] + " active");
                        employee = new Cashier(command[1], bank);
                        whoIsActiveStatus = EMPLOYEE;
                    } else {
                        account = bank.CheckIfAccountExists(command[1]);
                        if (account == null) {
                            System.out.println("Invalid request");
                            continue;
                        }
                        whoIsActiveStatus = ACCOUNT;
                        System.out.print("Welcome back, " + account.getUsername());
                    }
                    System.out.println();
                } else if (command[0].equalsIgnoreCase("INC")) {
                    bank.IncreaseYear();
                } else {
                    System.out.println("Please correct you mistyping!");
                }
            } else if (whoIsActiveStatus == ACCOUNT) {
                if (command[0].equalsIgnoreCase("Query")) {
                    account.Query();
                } else if (command[0].equalsIgnoreCase("Withdraw")) {
                    if (command.length != 2) {
                        System.out.println("Bad request!");
                        continue;
                    }
                    account.Withdraw(Double.parseDouble(command[1]), bank.getYear());
                } else if (command[0].equalsIgnoreCase("Deposit")) {
                    if (command.length != 2) {
                        System.out.println("Bad request!");
                        continue;
                    }
                    account.Deposit(Double.parseDouble(command[1]));
                } else if (command[0].equalsIgnoreCase("Request")) {
                    int status = account.RequestLoan(Double.parseDouble(command[1]));
                    if (status == 102) {
                        bank.AddLoanRequest(account);
                    }
                } else if (command[0].equalsIgnoreCase("Close")) {
                    whoIsActiveStatus = NOONE;
                    System.out.println("Transaction for " + account.getUsername() + " closed");
                } else {
                    System.out.println("Please correct you mistyping!");
                }
            } else if (whoIsActiveStatus == EMPLOYEE) {
                if (command[0].equalsIgnoreCase("Lookup")) {
                    if (command.length != 2) {
                        System.out.println("Bad request!");
                        continue;
                    }
                    employee.Lookup(command[1]);
                } else if (command[0].equalsIgnoreCase("Approve")) {
                    employee.ApproveLoan();
                } else if (command[0].equalsIgnoreCase("Change")) {
                    if (command.length != 3) {
                        System.out.println("Bad request!");
                        continue;
                    }
                    employee.ChangeInterestRate(command[1], Double.parseDouble(command[2]));
                } else if (command[0].equalsIgnoreCase("See")) {
                    employee.SeeInternalFund();
                } else if (command[0].equalsIgnoreCase("Close")) {
                    whoIsActiveStatus = NOONE;
                    System.out.println("Operations for " + employee.getUsername() + " closed");
                } else {
                    System.out.println("Please correct you mistyping!");
                }
            } else {
                System.out.println("Out of scope request");
            }
        }
    }
}
