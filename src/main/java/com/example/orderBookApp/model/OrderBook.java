package com.example.orderBookApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderBook {
	@Id
	@GeneratedValue(generator = "orderbook_seq", strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "orderbook_seq", sequenceName = "orderbook_sequence", allocationSize = 1)
	private Integer id;

	@Column(length = 20)
	private String bookName;
	private Double price;
	private Integer quantity;
	private Boolean side;

	public OrderBook(String bookname, Double price, Integer quantity, Boolean side) {
		super();
		this.bookName = bookname;
		this.price = price;
		this.quantity = quantity;
		this.side = side;
	}

	public OrderBook() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookname() {
		return bookName;
	}

	public void setBookname(String bookName) {
		this.bookName = bookName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getSide() {
		return side;
	}

	public void setSide(Boolean side) {
		this.side = side;
	}

}
