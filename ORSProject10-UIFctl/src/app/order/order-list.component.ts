import { Component, OnInit } from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseListCtl } from '../base-list.component';

@Component({
  selector: 'app-order-list',
  templateUrl: './order-list.component.html',
 
})
export class OrderListComponent extends BaseListCtl {


  public form = {

    error: false, //error 
    message: null, //error or success message
    preload: [], // preload data
    data: { id: null}, //form data
    inputerror: {}, // form input error messages
    searchParams: {}, //search form
    searchMessage: null, //search result message
    list: [ ], // search list 
    pageNo: 0
  };

  selectedFile: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message: string;
  isValidProductInput:boolean=true;
  isValidQuantityInput:boolean=true;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.ORDER, locator, route);
  }



  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'product':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidProductInput = !containsNonAlphabetic;
        break;
  
      case 'quantity':
        // Validate if input is a valid integer
        this.isValidQuantityInput = /^[0-9]*$/.test(value);
        break;
  
      // Add more cases for other fields as needed
      // case 'anotherField':
      //   // Validation logic for another field
      //   break;
  
      default:
        break;
    }
  }
  
}

