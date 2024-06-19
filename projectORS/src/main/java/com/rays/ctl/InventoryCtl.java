package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.InventoryDTO;
import com.rays.form.InventoryForm;
import com.rays.service.InventoryServiceInt;

@RestController
@RequestMapping( value = "inventory")
public class InventoryCtl extends BaseCtl<InventoryForm, InventoryDTO, InventoryServiceInt>{

	@Autowired
	InventoryServiceInt service ;
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);
		InventoryDTO dto = new InventoryDTO();
		List<DropdownList> list = service.search(dto, userContext);
		res.addResult("productList", list);
		return res;
	}
}
