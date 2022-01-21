package com.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.pojo.TransactionDetails;
import com.util.TransactionsUtility;

public class AccountBalanceCalculatorTest {
	static ArrayList<TransactionDetails> transactionsList;
	static LocalDateTime fromDate;
	static LocalDateTime toDate;

	@BeforeAll
	static void loadTransactions() throws IOException {
		transactionsList = TransactionsLoader.loadTransactions("src/test/resources/AllTransactionsTest4.csv");
		fromDate = LocalDateTime.parse("20/10/2018 12:00:00", TransactionsUtility.DATETIMEFORMATTER);
		toDate = LocalDateTime.parse("20/10/2018 19:00:00", TransactionsUtility.DATETIMEFORMATTER);
	}

	@Test
	@DisplayName("Testing for account ACC334455")
	void testFetchRelativeBalance() {
		String accountId = "ACC334455";
		Assertions.assertEquals(-25.00,
				(new AccountBalanceCalculator().fetchRelativeBalance(transactionsList, accountId, fromDate, toDate))
						.getRelativeBalance());
		Assertions.assertEquals(1,
				(new AccountBalanceCalculator().fetchRelativeBalance(transactionsList, accountId, fromDate, toDate))
						.getNumberOfTransactions());
	}

	@Test
	@DisplayName("Testing for account ACC778899")
	void testFetchRelativeBalance1() {
		String accountId = "ACC778899";
		Assertions.assertEquals(30.00,
				(new AccountBalanceCalculator().fetchRelativeBalance(transactionsList, accountId, fromDate, toDate))
						.getRelativeBalance());
		Assertions.assertEquals(2,
				(new AccountBalanceCalculator().fetchRelativeBalance(transactionsList, accountId, fromDate, toDate))
						.getNumberOfTransactions());
	}

}
