package com.example.orderBookApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.orderBookApp.model.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {

	OrderBook save(Optional<OrderBook> existingOrderBook);

}



