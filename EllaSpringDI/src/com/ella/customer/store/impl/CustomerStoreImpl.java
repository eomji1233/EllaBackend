package com.ella.customer.store.impl;

import java.util.ArrayList;
import java.util.List;

import com.ella.customer.domain.CustomerVO;
import com.ella.customer.store.CustomerStore;

public class CustomerStoreImpl implements CustomerStore {

	@Override
	public int insertCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyCustomer(CustomerVO customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CustomerVO> selectList() {
		List<CustomerVO> cList = new ArrayList<CustomerVO>();
		for(int i = 0; i < 10; i++) {
			CustomerVO customer = new CustomerVO("khuser"+i, i+"¿ëÀÚ", i+"", i+"");
			cList.add(customer);
		}
		return cList;
	}

	@Override
	public CustomerVO selectOneById(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
