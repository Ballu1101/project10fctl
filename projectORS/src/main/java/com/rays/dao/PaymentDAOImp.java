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
import com.rays.dto.PaymentDTO;

@Repository
public class PaymentDAOImp extends BaseDAOImpl<PaymentDTO> implements PaymentDAOInt{

	@Override
	protected List<Predicate> getWhereClause(PaymentDTO dto, CriteriaBuilder builder, Root<PaymentDTO> qRoot) {
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getAccountHolderName())) {

			whereCondition.add(builder.like(qRoot.get("accountHolderName"), dto.getAccountHolderName() + "%"));
		}
		if (!isEmptyString(dto.getBranch())) {

			whereCondition.add(builder.like(qRoot.get("branch"), dto.getBranch() + "%"));
		}
		if (!isEmptyString(dto.getPaymentType())) {

			whereCondition.add(builder.like(qRoot.get("paymentType"), dto.getPaymentType() + "%"));
		}
		
		if (isNotNull(dto.getPaymentDate())) {
			// Assuming "dateOfPurchase" field is of type java.util.Date or java.sql.Date
			Date searchDate = dto.getPaymentDate();

			// Define start and end dates for the search day
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

			// Create predicate for date range
			Predicate datePredicate = builder.between(qRoot.get("paymentDate"), startDate, endDate);
			whereCondition.add(datePredicate);
		}
		
		return whereCondition;
	}

	@Override
	public Class<PaymentDTO> getDTOClass() {
	
		return PaymentDTO.class;
	}

}
