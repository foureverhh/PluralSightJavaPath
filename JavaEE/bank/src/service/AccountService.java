package service;

import pojo.Account;

import java.io.IOException;

public interface AccountService {
    int ACCOUNT_PASSWORD_NOT_MATCH = 1;
    int ACCOUNT_BALANCE_NOT_ENOUGH = 2;
    int ACCOUNT_NAME_NOT_MATCH = 3;
    int TRANSFER_FAILURE = 4;
    int TRANSFER_SUCCESS = 5;
    int transfer(Account receiver, Account sender) throws IOException;
}
