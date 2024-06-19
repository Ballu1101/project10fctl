import { Component, OnInit } from '@angular/core';
import { BaseCtl } from '../base.component';
import { FormGroup } from '@angular/forms';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html'})
export class PaymentComponent extends BaseCtl {

  selected = null;
 
  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute, private httpClient: HttpClient) {
    super(locator.endpoints.PAYMENT, locator, route);
  }

  



  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
   
    flag = flag && validator.isNotNullObject(form.accountHolderName);
    console.log(form.accountHolderName);
    flag = flag && validator.isNotNullObject(form.accountNo);
    console.log(form.accountNo);
    flag = flag && validator.isNotNullObject(form.branch);
    console.log(form.branch);
    flag = flag && validator.isNotNullObject(form.paymentType);
    console.log(form.paymentType);
    flag = flag && validator.isNotNullObject(form.paymentDate);
    console.log(form.paymentDate);
    

    flag = flag && validator.isNotNullObject(form.gender);
    console.log(form.gender + 'gender--');
   
    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    console.log(form.id + 'populate form in paymentcomponent');
    form.accountHolderName = data.accountHolderName;
    form.accountNo = data.accountNo;
    form.paymentType = data.paymentType;
    form.paymentDate = data.paymentDate;
    form.gender = data.gender;
    console.log(form.gender + 'gender--');
   
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
