package com.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.pojo.AccountDetails;
import com.pojo.TransactionDetails;

public class AccountBalanceCalculator {

	public AccountDetails fetchRelativeBalance(List<TransactionDetails> transactionsList, String accountId,
			LocalDateTime fromDate, LocalDateTime toDate) {

		AccountDetails accountDetails = new AccountDetails();

		ArrayList<String> reversalTransactionsList = new ArrayList<>();
		transactionsList.forEach(transaction -> {
			if ((transaction.getFromAccountId().equalsIgnoreCase(accountId)
					|| transaction.getToAccountId().equalsIgnoreCase(accountId))
					&& (transaction.getTransactionType().equals("REVERSAL"))) {
				reversalTransactionsList.add(transaction.getRelatedTransaction());
			}
		});
		transactionsList.forEach(transaction -> {
			if (transaction.getCreatedAt().compareTo(fromDate) >= 0 && transaction.getCreatedAt().compareTo(toDate) <= 0
					&& (transaction.getFromAccountId().equalsIgnoreCase(accountId)
							|| transaction.getToAccountId().equalsIgnoreCase(accountId))
					&& (transaction.getTransactionType().equals("PAYMENT"))
					&& !reversalTransactionsList.contains(transaction.getTransactionId())) {
				if (transaction.getFromAccountId().equalsIgnoreCase(accountId)) {
					accountDetails.setRelativeBalance(accountDetails.getRelativeBalance() - transaction.getAmount());
				} else {
					accountDetails.setRelativeBalance(accountDetails.getRelativeBalance() + transaction.getAmount());
				}
				accountDetails.setNumberOfTransactions(accountDetails.getNumberOfTransactions() + 1);
			}
		});
		return accountDetails;
	}
}
