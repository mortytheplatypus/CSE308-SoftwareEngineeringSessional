#include <bits/stdc++.h>
#include "Account.cpp"
using namespace std;

#define ACCOUNT 23
#define EMPLOYEE 24
#define NOONE 25

vector<double> interestRates{0.1, 0.05, 0.15};
class Bank {
    int MD, officer[2], cashiers[5];
    vector<Account> accounts;
    stack<Account> LoanRequests;
    int yearOfOperation;
    double internalFund;
    
public:
    Bank() {
        cout << "Bank Created; MD, S1, S2, ";
        cout << "C1, C2, C3, C4, C5 created\n";

        internalFund = 1000000;
        yearOfOperation = 0;
    }

    double getInternalFund() {
        return internalFund;
    }

    void DecreaseInternalFund(double amount) {
        internalFund -= amount;
    }

    void increaseTime() {
        yearOfOperation++;

        //decrease loan
        for (Account account : accounts) {
            account.DecreaseLoan(account.getLoan()*0.1);
            account.IncreaseBalance(account.getBalance()*interestRates[account.getType()]);
            account.DecreaseBalance(500 < account.getBalance() ? 500 : account.getBalance());
        }
    }

    int CheckIfAccountExists(string username) {
        for (Account account : accounts) {
            if (account.getUsername() == username) {
                return ACCOUNT;
            }
        }
        return EMPLOYEE;
    }

    void addAccount(Account account) {
        accounts.push_back(account);
    }

    void addLoanRequest(Account account) {
        LoanRequests.push(account);
    }

    void removeLoanRequest() {
        LoanRequests.pop();
    }

    vector<Account> getAccounts() {
        return accounts;
    }

    int getTime() {
        return yearOfOperation;
    }


    Account AccountLogin(string username) {
        Account account;
        for (Account account : accounts) {
            if (account.getUsername() == username) {
                account.MakeActive();
                return account;
            }
        }
        return account;
        // whoIsActiveStatus = ACCOUNT;
    }

    void AccountLogout(string username) {
        for (Account account : accounts) {
            if (account.getUsername() == username) {
                account.MakeInactive();
            }
        }
    }
};