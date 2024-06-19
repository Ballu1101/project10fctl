package com.rays.dto;

import java.util.Date;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table (name = "st_payment")
public class PaymentDTO extends BaseDTO{
	
	@Column(name = "Account_Holder_Name")
	private String accountHolderName;
	
	@Column(name = "Account_No")
	private Long accountNo;
	
	@Column(name = "Branch")
	private String branch;
	
	@Column(name = "Payment_Type")
	private String paymentType;
	
	@Column(name = "Payment_Date")
	private Date paymentDate;
	
	
	
	

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
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

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return accountNo + "";
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "accountNo";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return accountNo +"" ;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "accountNonnnn";
	}

	@Override
	public LinkedHashMap<String, String> orderBY() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("accountHolderName", "asc");
		return  map;
		
	}

	@Override
	public LinkedHashMap<String, Object> uniqueKeys() {
		LinkedHashMap<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("accountHolderName", "asc");
		return  map;
	}
	
	

}
