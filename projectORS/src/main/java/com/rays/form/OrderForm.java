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
import com.rays.dto.OrderDTO;
import com.rays.validation.ValidDate;
import com.rays.validation.ValidLong;

public class OrderForm extends BaseForm {

	@NotNull(message = "please enter quantity")
	private String quantity;

	@NotEmpty(message = "please enter  product")
	@Pattern(regexp = "^[a-zA-Z.]*$", message = "Please enter alphabetic characters or periods only")
	private String product;

	@NotEmpty(message = "please enter dob")
//	@Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])", message = "plzz enter valid formate")
	@ValidDate(message = "plzz enter valid formate")
	private String dob;

	@NotNull(message = "please enter ammount")
	@ValidLong(message = "please enter ammount")
	private String ammount;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAmmount() {
		return ammount;
	}

	public void setAmmount(String ammount) {
		this.ammount = ammount;
	}

	@Override
	public BaseDTO getDto() {

		OrderDTO dto = initDTO(new OrderDTO());
		if (quantity != null && !quantity.isEmpty()) {
			dto.setQuantity(Long.valueOf(quantity));

		}
		dto.setProduct(product);
		if (dob != null && !dob.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date parsedDate = dateFormat.parse(dob);
				dto.setDob(parsedDate);
			} catch (ParseException e) {
				// Handle parse exception if needed
				e.printStackTrace();
			}
		}
		if (ammount != null && !ammount.isEmpty()) {
			dto.setAmmount(Long.valueOf(ammount));

		}
		return dto;
	}

}
