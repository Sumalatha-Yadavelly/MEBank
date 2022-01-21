package com.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.stream.Stream;

import com.pojo.TransactionDetails;
import com.util.TransactionsUtility;

public class TransactionsLoader {

	public static ArrayList<TransactionDetails> loadTransactions(String path)
			throws DateTimeParseException, NumberFormatException, IOException {
		ArrayList<TransactionDetails> transactions = new ArrayList<>();
		try (Stream<String> lines = Files.lines(Paths.get(path))) {
			lines.forEach(line -> {

				TransactionDetails transactionDetails = new TransactionDetails();
				String[] transactionDetailsArray = line.split(",");

				transactionDetails.setTransactionId(transactionDetailsArray[0]);
				transactionDetails.setFromAccountId(transactionDetailsArray[1]);
				transactionDetails.setToAccountId(transactionDetailsArray[2]);
				transactionDetails.setCreatedAt(
						LocalDateTime.parse(transactionDetailsArray[3], TransactionsUtility.DATETIMEFORMATTER));
				transactionDetails.setAmount(Double.parseDouble(transactionDetailsArray[4]));
				transactionDetails.setTransactionType(transactionDetailsArray[5]);
				if (transactionDetailsArray.length > 6) {
					transactionDetails.setRelatedTransaction(transactionDetailsArray[6]);
				}
				transactions.add(transactionDetails);
			});
		}
		return transactions;
	}
}
