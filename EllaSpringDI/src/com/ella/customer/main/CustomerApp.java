package com.ella.customer.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.ella.customer.domain.CustomerVO;
import com.ella.customer.service.CustomerService;
import com.ella.customer.service.impl.CustomerServiceImpl;

public class CustomerApp {
	public static void main(String[] args) {
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
//		CustomerService cService = new CustomerServiceImpl();
		CustomerService cService = (CustomerServiceImpl)ctx.getBean("customerService");
		// 클래스와 클래스 사이에 인터페이스 껴서 의존성 낮춤
		List<CustomerVO> cList = cService.selectList();
		if(!cList.isEmpty()) {
			for(CustomerVO customer : cList) {
				System.out.println(customer.toString());
			}
		}
	}
}
