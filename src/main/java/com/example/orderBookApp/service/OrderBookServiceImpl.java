package com.example.orderBookApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderBookApp.exception.BookNotFoundException;
import com.example.orderBookApp.model.OrderBook;
import com.example.orderBookApp.repository.OrderBookRepository;



@Service
public class OrderBookServiceImpl implements OrderBookService {
	
	private OrderBookRepository orderBookRepository;
	
    @Autowired
	public void setOrderBookRepository(OrderBookRepository orderBookRepository) {
		this.orderBookRepository = orderBookRepository;
	}

	@Override
	public OrderBook addBook(OrderBook book) {
		// TODO Auto-generated method stub
		return orderBookRepository.save(book);
	}

	@Override
	public OrderBook updateBook(OrderBook book) {
		// TODO Auto-generated method stub
		return orderBookRepository.save(book);
	}

	@Override
	public void deleteBookById(int bookID) {
		// TODO Auto-generated method stub
		orderBookRepository.deleteById(bookID);
	}

	@Override
	public OrderBook getBookById(int bookID) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return orderBookRepository.findById(bookID).orElseThrow(()-> new BookNotFoundException("Invalid Id"));
		
	}

	@Override
	public List<OrderBook> getAllBooks() {
		// TODO Auto-generated method stub
		return orderBookRepository.findAll();
	}

}
