package com.ty.password.store.service;

import java.util.List;

import com.ty.password.store.dao.EmployeeDao;
import com.ty.password.store.dto.Employee;

public class EmployeeService {

	EmployeeDao employeeDao=new EmployeeDao();
	public Employee saveEmployeea(Employee employee) {
		return employeeDao.saveEmployee(employee);
	}
	public List<Employee> validateEmployee(String name, String phone) {
		return employeeDao.validateEmployee(name, phone);
	}
}
