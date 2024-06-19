package com.rays.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InventoryDTO;

@Repository
public class InventoryDAOImp extends BaseDAOImpl<InventoryDTO> implements InventoryDAOInt{

	@Override
	protected List<Predicate> getWhereClause(InventoryDTO dto, CriteriaBuilder builder, Root<InventoryDTO> qRoot) {
	List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (dto.getId() !=null && dto.getId() > 0) {

			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}
		if (!isZeroNumber(dto.getQuantity())) {

			whereCondition.add(builder.equal(qRoot.get("quantity"), dto.getQuantity()));
		}
		if (!isEmptyString(dto.getSupplierName())) {

			whereCondition.add(builder.like(qRoot.get("supplierName"), dto.getSupplierName() + "%"));
		}
		 if (dto.getLastUpdateDate() != null) {
	            Date searchDate = dto.getLastUpdateDate();

	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(searchDate);
	            calendar.set(Calendar.HOUR_OF_DAY, 0); // Start of the day
	            calendar.set(Calendar.MINUTE, 0);
	            calendar.set(Calendar.SECOND, 0);
	            Date startDate = calendar.getTime();

	            calendar.set(Calendar.HOUR_OF_DAY, 23); // End of the day
	            calendar.set(Calendar.MINUTE, 59);
	            calendar.set(Calendar.SECOND, 59);
	            Date endDate = calendar.getTime();

	            Predicate datePredicate = builder.between(qRoot.get("lastUpdatedDate"), startDate, endDate);
	            whereCondition.add(datePredicate);
	        }
		 
			if (!isEmptyString(dto.getProduct())) {

				whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct() + "%"));
			}
		 
		 
		
		return whereCondition;
	}

	@Override
	public Class<InventoryDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return InventoryDTO.class;
	}

}
