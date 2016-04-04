package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.EmployeeEntity;
import com.example.repository.EmployeeRepository;
import com.example.vo.EmployeeVo;

@RestController
@RequestMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<EmployeeVo> getAll() {
		List<EmployeeVo> employeesVo = new ArrayList<EmployeeVo>(); 
		List<EmployeeEntity> employeesEntity = employeeRepository.findAll();
		
		for (EmployeeEntity employeeEntity : employeesEntity) {
			EmployeeVo employeeVo = new EmployeeVo();
			BeanUtils.copyProperties(employeeEntity, employeeVo);
			
			employeesVo.add(employeeVo);
		}
		
		return employeesVo;
	}
	
}
