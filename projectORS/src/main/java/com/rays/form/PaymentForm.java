package com.rays.form;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.PaymentDTO;


public class PaymentForm extends BaseForm {

	@NotEmpty(message = "please enter  accountHolderName")
	@Pattern(regexp = "^[a-zA-Z.]*$", message = "Please enter alphabetic characters or periods only")
	private String accountHolderName;
	
	@NotNull(message = "please enter accountNo")
	@Pattern(regexp = "^[0-9]{1,12}$", message = "Please enter a valid amount")
	private String accountNo;
	
	@NotEmpty(message = "please enter branch")
	private String branch;
	
	@NotEmpty(message = "please enter paymentType")
	private String paymentType;
	
	@NotEmpty(message = "please enter paymentDate")
	@Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])", message = "plzz enter valid formate")
	private String paymentDate;
	
	
	
	

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public BaseDTO getDto() {
	PaymentDTO dto = initDTO(new PaymentDTO());
	dto.setAccountHolderName(accountHolderName);
	if(accountNo!= null && !accountNo.isEmpty()) {
		dto.setAccountNo(Long.valueOf(accountNo));
		
	}
	dto.setBranch(branch);
	dto.setPaymentType(paymentType);
	if (paymentDate != null && !paymentDate.isEmpty()) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date parsedDate = dateFormat.parse(paymentDate);
			dto.setPaymentDate(parsedDate);
		} catch (ParseException e) {
			// Handle parse exception if needed
			e.printStackTrace();
		
	}
	}
	return dto;
}
	
}