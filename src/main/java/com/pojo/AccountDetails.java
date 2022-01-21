package com.pojo;

public class AccountDetails {

	private Double relativeBalance = 0.0;
	private int numberOfTransactions;

	public AccountDetails(Double relativeBalance, int numberOfTransactions) {

		this.relativeBalance = relativeBalance;
		this.numberOfTransactions = numberOfTransactions;
	}

	public AccountDetails() {

	}

	public Double getRelativeBalance() {
		return relativeBalance;
	}

	public void setRelativeBalance(Double relativeBalance) {
		this.relativeBalance = relativeBalance;
	}

	public int getNumberOfTransactions() {
		return numberOfTransactions;
	}

	public void setNumberOfTransactions(int numberOfTransactions) {
		this.numberOfTransactions = numberOfTransactions;
	}

	@Override
	public String toString() {
		return "AccountDetails{" + "relativeBalance='" + relativeBalance + '\'' + ", numberOfTransactions='"
				+ numberOfTransactions + '\'' + '}';
	}

}
