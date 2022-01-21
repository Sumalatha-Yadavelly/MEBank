package com.service;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionsLoaderTest {

	@Test
	@DisplayName("To test Invalid date format scenario")
	public void testloadTransactionsInvalidDate() throws IOException {
		Assertions.assertThrows(DateTimeParseException.class,
				() -> TransactionsLoader.loadTransactions("src/test/resources/AllTransactionsTest.csv"));
	}

	@Test
	@DisplayName("To test Invalid amount value scenario")
	public void testloadTransactionsInvalidAmount() throws IOException {
		Assertions.assertThrows(NumberFormatException.class,
				() -> TransactionsLoader.loadTransactions("src/test/resources/AllTransactionsTest2.csv"));
	}

	@Test
	@DisplayName("Fetching transactions list success scenario")
	public void testloadTransactions() throws IOException {
		Assertions.assertEquals(5,
				(TransactionsLoader.loadTransactions("src/test/resources/AllTransactionsTest3.csv")).size());
	}

}
