package com.rays.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.ClientDTO;

public class ClientForm extends BaseForm {

	@NotEmpty(message = "please enter  name")
	private String name;

	@NotEmpty(message = "please enter  address")
	private String address;

	@NotNull(message = "please enter phone")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;

	@NotEmpty(message = "please enter  priority")
	private String priority;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public BaseDTO getDto() {
		ClientDTO dto = initDTO(new ClientDTO());
		dto.setName(name);
		dto.setAddress(address);
		dto.setPhone(phone);
		dto.setPriority(priority);
		return dto;
	}
}
