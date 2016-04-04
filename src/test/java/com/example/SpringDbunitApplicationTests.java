package com.example;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringDbunitApplicationTest.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, 
	DbUnitTestExecutionListener.class})
@DatabaseSetups({
	@DatabaseSetup(value = "classpath:company-dataset.xml", type = DatabaseOperation.CLEAN_INSERT),
	@DatabaseSetup(value = "classpath:employee-dataset.xml", type = DatabaseOperation.CLEAN_INSERT)
})
public class SpringDbunitApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Test
	public void test() {
		int quantityOfEmployeeExpected = 9;
		
		List<EmployeeEntity> allEmployees = employeeRepository.findAll();
		
		Assert.assertEquals(quantityOfEmployeeExpected, allEmployees.size());
	}

}
