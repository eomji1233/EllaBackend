package com.ella.customer.service.impl;

import java.util.List;

import com.ella.customer.domain.CustomerVO;
import com.ella.customer.service.CustomerService;
import com.ella.customer.store.CustomerStore;
import com.ella.customer.store.impl.CustomerStoreImpl;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerStore cStore;
	
	public CustomerServiceImpl() {
//		cStore = new CustomerStoreImpl(); = 의존성 주입
	}
	
	// 1. setter 메소드를 이용하여 의존성 주입
	public void setStore(CustomerStore cStore) {
		this.cStore = cStore;
		// 필드에 객체를 주입해주기 위해 같이 작성해줘야함 property태그
	}
	
	// 2. 생성자를 이용한 의존성 주입
	public CustomerServiceImpl(CustomerStore cStore) {
		this.cStore = cStore;
		// constructor-arg 태그
	}
	
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
		List<CustomerVO> cList = cStore.selectList();
		return cList;
	}

	@Override
	public CustomerVO selectOneById(String customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
