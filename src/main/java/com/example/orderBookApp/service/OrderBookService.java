package com.example.orderBookApp.service;

import java.util.List;

import com.example.orderBookApp.exception.BookNotFoundException;
import com.example.orderBookApp.model.OrderBook;


public interface OrderBookService {
	OrderBook addBook(OrderBook book );
	OrderBook updateBook(OrderBook book );
	void deleteBookById(int bookID);
	
	OrderBook getBookById(int bookID)throws BookNotFoundException;
	List <OrderBook> getAllBooks();

}
