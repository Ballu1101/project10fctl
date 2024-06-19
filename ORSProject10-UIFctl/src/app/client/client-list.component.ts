import { Component, OnInit } from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseListCtl } from '../base-list.component';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  
})
export class ClientListComponent extends BaseListCtl {


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
  isValidNameInput:boolean=true;
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.CLIENT, locator, route);
  }

  validateInput(event: any, field: string) {
    const value = event.target.value;
  
    switch(field) {
      case 'name':
        const containsNonAlphabetic = /[^\sa-zA-Z]/.test(value);
        this.isValidNameInput = !containsNonAlphabetic;
        break;

      
}
  }
}
