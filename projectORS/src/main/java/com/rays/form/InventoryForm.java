package com.rays.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.InventoryDTO;

public class InventoryForm extends BaseForm {

	@NotEmpty(message = "plzz enter supplierName")
	@Pattern(regexp = "^[a-zA-Z.]*$", message = "Please enter alphabetic characters or periods only")
//	@Pattern(regexp = "^[a-zA-Z]*$", message = "Please enter alphabetic characters only")
	private String supplierName;

	@NotEmpty(message = "plzz enter lastUpdateDate")
	@Pattern(regexp = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])", message = "plzz enter valid formate")
	private String lastUpdateDate;

	@NotNull(message = "plzz enter quantity")
	private String quantity;

	@NotEmpty(message = "plzz enter product")
	private String product;

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

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

	@Override
	public BaseDTO getDto() {
		InventoryDTO dto = initDTO(new InventoryDTO());
		dto.setSupplierName(supplierName);
		if (lastUpdateDate != null && !lastUpdateDate.isEmpty()) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

				Date parseDate = dateFormat.parse(lastUpdateDate);
				dto.setLastUpdateDate(parseDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (quantity != null && !quantity.isEmpty()) {
			dto.setQuantity(Long.valueOf(quantity));
		}
		dto.setProduct(product);
		

		return dto;
	}
}
