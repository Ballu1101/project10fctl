package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.ClientDTO;

@Repository
public class ClientDAOImp extends BaseDAOImpl<ClientDTO> implements ClientDAOInt{

	@Override
	protected List<Predicate> getWhereClause(ClientDTO dto, CriteriaBuilder builder, Root<ClientDTO> qRoot) {
		
		List<Predicate> whereCondition = new ArrayList<Predicate>();
		
		if (!isEmptyString(dto.getName())) {

			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		if (!isEmptyString(dto.getAddress())) {

			whereCondition.add(builder.like(qRoot.get("address"), dto.getAddress() + "%"));
		}
		if (!isEmptyString(dto.getPhone())) {

			whereCondition.add(builder.like(qRoot.get("phone"), dto.getPhone() + "%"));
		}
		
		return whereCondition;
	}
	

	@Override
	public Class<ClientDTO> getDTOClass() {
		
		return ClientDTO.class;
	}

}
