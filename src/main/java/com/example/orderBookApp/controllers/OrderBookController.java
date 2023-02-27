package com.example.orderBookApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderBookApp.model.OrderBook;
import com.example.orderBookApp.service.OrderBookServiceImpl;


@RestController
@RequestMapping("/orderbook")
public class OrderBookController {

	@Autowired
	private OrderBookServiceImpl orderBookServiceImpl;
	
	@GetMapping("/welcome")
	public String welcomeHome() {
		return "Welcome";
	}

	@GetMapping("/all")
	public ResponseEntity<List<OrderBook>> getAllBooks() {
		List<OrderBook> employees = orderBookServiceImpl.getAllBooks();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<OrderBook> getOrderBookByID(@PathVariable("id") Integer id) {
		OrderBook orderBook = orderBookServiceImpl.getBookById(1);
		return new ResponseEntity<>(orderBook, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<OrderBook> addBook(@RequestBody OrderBook orderBook) {
		OrderBook newOrderBook = orderBookServiceImpl.addBook(orderBook);
		return new ResponseEntity<>(newOrderBook, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<OrderBook> updateBook(@RequestBody OrderBook orderBook) {
		OrderBook updateOrderBook = orderBookServiceImpl.updateBook(orderBook);
		return new ResponseEntity<>(updateOrderBook, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id) {
		orderBookServiceImpl.deleteBookById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
