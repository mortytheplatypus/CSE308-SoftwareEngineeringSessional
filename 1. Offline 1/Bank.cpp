#include <bits/stdc++.h>
#include "Account.cpp"
using namespace std;

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
        //adjust loans and their interests 
        int n = accounts.size();

        //decrease loan
        for (Account account : accounts) {
            account.DecreaseLoan(account.getLoan()*0.1);
            account.IncreaseBalance(account.getBalance()*interestRates[account.getType()]);
            account.DecreaseBalance(500 < account.getBalance() ? 500 : account.getBalance());
        }
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
};