#include <bits/stdc++.h>
#include "Account.cpp"
using namespace std;

class Bank {
    int MD, officer[2], cashiers[5];
    vector<Account> accounts;
    stack<Account> LoanRequests;
    int yearOfOperation;
    int fund;
public:
    Bank() {
        cout << "Bank Created; MD, S1, S2, ";
        cout << "C1, C2, C3, C4, C5 created\n";

        fund = 1000000;
        yearOfOperation = 0;
    }

    void increaseTime() {
        yearOfOperation++;
    }
};