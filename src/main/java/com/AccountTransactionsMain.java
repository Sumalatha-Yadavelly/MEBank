package com;

import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;

import com.pojo.AccountDetails;
import com.pojo.TransactionDetails;
import com.service.AccountBalanceCalculator;
import com.service.TransactionsLoader;
import com.util.TransactionsUtility;

public class AccountTransactionsMain {
	
    public static void main(String[] args) {
    	String filePath = args[0];
        String accountId = args[1];
        String from = args[2];
        String to = args[3];
        
        // To fetch transactions
        List<TransactionDetails> transactionsList;
        AccountDetails accountDetails = null;
		try {
			transactionsList = TransactionsLoader.loadTransactions(filePath);
			//To fetch Relative Account Balance
			LocalDateTime fromDate = LocalDateTime.parse(from, TransactionsUtility.DATETIMEFORMATTER);
	    	LocalDateTime toDate = LocalDateTime.parse(to, TransactionsUtility.DATETIMEFORMATTER);
	        accountDetails = new AccountBalanceCalculator().fetchRelativeBalance(transactionsList, accountId,
	        		fromDate, toDate);
	        // To Display Relative Account Balance
	        System.out.println("Relative Balance for the period is: " + NumberFormat.getCurrencyInstance().format(accountDetails.getRelativeBalance()));
	        System.out.println("Number of transactions included is: " + accountDetails.getNumberOfTransactions());
		}  catch (DateTimeParseException e){
        	System.out.println("Invalid Date format error.");
        } catch (NumberFormatException e){
        	System.out.println("Invalid Amount value error.");
        } catch (Exception e){
        	System.out.println("Transaction data is not valid");
        }
    
    }
}
