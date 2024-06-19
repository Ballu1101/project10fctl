import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  
})
export class InventoryComponent extends BaseCtl {

  selected = null;
 
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.INVENTORY, locator, route);
  }

  



  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
   
    flag = flag && validator.isNotNullObject(form.supplierName);
    console.log(form.supplierName);
    flag = flag && validator.isNotNullObject(form.lastUpdateDate);
    console.log(form.lastUpdateDate);
    flag = flag && validator.isNotNullObject(form.quantity);
    console.log(form.quantity);
    flag = flag && validator.isNotNullObject(form.product);
    console.log(form.product);
   
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    console.log(form.id + 'populate form in paymentcomponent');
    form.supplierName = data.supplierName;
    form.lastUpdateDate = data.lastUpdateDate;
    form.quantity = data.quantity;
    form.product = data.product;
   
  }
  parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }
  test() {

  }


}