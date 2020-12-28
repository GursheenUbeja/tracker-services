package com.expensetracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "expenditure")
public class Expenditure {

	@Id
	private String transactionId;
	
	private String title;
	
	private Integer amount;
	
	private String description;
	
	private String category;
	
	private String prurchaseDate;
	
	public Expenditure() {
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPrurchaseDate() {
		return prurchaseDate;
	}

	public void setPrurchaseDate(String prurchaseDate) {
		this.prurchaseDate = prurchaseDate;
	}

	public Expenditure(String transactionId, String title, Integer amount, String description, String category,
			String prurchaseDate) {
		super();
		this.transactionId = transactionId;
		this.title = title;
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.prurchaseDate = prurchaseDate;
	}
	
}
