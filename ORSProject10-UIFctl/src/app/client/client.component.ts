import { Component, OnInit } from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BaseCtl } from '../base.component';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  
})
export class ClientComponent extends BaseCtl {

  selected = null;
 
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.CLIENT, locator, route);
  }

  



  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
   
    flag = flag && validator.isNotNullObject(form.name);
    console.log(form.name);
    flag = flag && validator.isNotNullObject(form.address);
    console.log(form.address);
    flag = flag && validator.isNotNullObject(form.phone);
    console.log(form.phone);
    flag = flag && validator.isNotNullObject(form.priority);
    console.log(form.priority);
    
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    console.log(form.id + 'populate form in paymentcomponent');
    form.name = data.name;
    form.address = data.address;
    form.phone = data.phone;
    form.priority = data.priority;
   
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