import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { OrderBook } from './orderBook';
import { OrderBookService } from './orderbook.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'orderbookmanagerapp';
  public orderBooks: OrderBook[] = [];
  public editOrderBook! : OrderBook;
  public deleteOrderBook! : OrderBook;


  constructor(private orderBookService: OrderBookService) { }

  ngOnInit(){
    this.getOrderBooks();
  }

  public getOrderBooks(): void {
    this.orderBookService.getOrderBooks().subscribe(
      (response: OrderBook[]) => {
        this.orderBooks = response;
        console.log(this.orderBooks);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);

      }

    )
  }


  public onAddOrderBook(addForm: NgForm): void {
      document.getElementById("add-orderbook-form")?.click();
      this.orderBookService.addOrderBook(addForm.value).subscribe(
        (response: OrderBook) => {
          console.log(response);
          this.getOrderBooks();
          addForm.reset();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
  }

  public onUpdateOrderBook(orderBook: OrderBook): void {
    this.orderBookService.updateOrderBook(orderBook).subscribe(
      (response: OrderBook) => {
        console.log(response);
        this.getOrderBooks();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
}

public onDeleteBookOrder(orderBookId: number): void {
  this.orderBookService.deleteOrderBook(orderBookId).subscribe(
    (response: void) => {
      console.log(response);
      this.getOrderBooks();
    },
    (error: HttpErrorResponse) => {
      alert(error.message);
    }
  );
}



  public onOpenModal(orderBook: any, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addOrderBookModal');
      console.log(button);
    }
    if (mode === 'edit') {
      this.editOrderBook = orderBook;
      button.setAttribute('data-target', '#updateOrderBookModal');
      console.log(button);
    }
    if (mode === 'delete') {
      this.deleteOrderBook= orderBook;
      button.setAttribute('data-target', '#deleteOrderBookModal');
    }
    container?.appendChild(button);
    console.log(container);
    console.log("add button is clicked");
    button.click()

  }



}
