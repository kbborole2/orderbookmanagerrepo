import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { environment } from 'src/environments/environment';
import { OrderBook } from './orderBook';
import { environment } from 'src/environment/environment';

@Injectable({providedIn: 'root'})
export class OrderBookService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient){}

  public getOrderBooks(): Observable<OrderBook[]> {
    return this.http.get<OrderBook[]>(`${this.apiServerUrl}/orderbook/all`);
  }

  public addOrderBook(orderBook: OrderBook): Observable<OrderBook> {
    return this.http.post<OrderBook>(`${this.apiServerUrl}/orderbook/add`, orderBook);
  }

  public updateOrderBook(orderBook: OrderBook): Observable<OrderBook> {
    return this.http.put<OrderBook>(`${this.apiServerUrl}/orderbook/update`, orderBook);
  }

  public deleteOrderBook(orderBookId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/orderbook/delete/${orderBookId}`);
  }
}
