package com.pojo;

import java.time.LocalDateTime;

public class TransactionDetails {

	private String transactionId;
	private String fromAccountId;
	private String toAccountId;
	private LocalDateTime createdAt;
	private Double amount;
	private String transactionType;
	private String relatedTransaction;

	public TransactionDetails(String transactionId, String fromAccountId, String toAccountId, LocalDateTime createdAt,
			Double amount, String transactionType, String relatedTransaction) {
		this.transactionId = transactionId;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.createdAt = createdAt;
		this.amount = amount;
		this.transactionType = transactionType;
		this.relatedTransaction = relatedTransaction;
	}

	public TransactionDetails() {
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getRelatedTransaction() {
		return relatedTransaction;
	}

	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}

	@Override
	public String toString() {
		return "TransactionDetails{" + "transactionId='" + transactionId + '\'' + ", fromAccountId='" + fromAccountId
				+ '\'' + ", toAccountId='" + toAccountId + '\'' + ", createdAt=" + createdAt + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", relatedTransaction='" + relatedTransaction + '\'' + '}';
	}
}
