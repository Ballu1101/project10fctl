import { Component, OnInit } from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseCtl } from '../base.component';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
 
})
export class OrderComponent extends BaseCtl {

  selected = null;
 
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.ORDER, locator, route);
  }

  



  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
   
    flag = flag && validator.isNotNullObject(form.quantity);
    console.log(form.quantity);
    flag = flag && validator.isNotNullObject(form.product);
    console.log(form.product);
    flag = flag && validator.isNotNullObject(form.dob);
    console.log(form.dob);
    flag = flag && validator.isNotNullObject(form.ammount);
    console.log(form.ammount);
   
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    console.log(form.id + 'populate form in ordercomponent');
    form.quantity = data.quantity;
    form.product = data.product;
    form.dob = data.dob;
    form.ammount = data.ammount;
   
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