package com.ty.password.store.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.password.store.dto.Employee;

public class EmployeeDao {

	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public  Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee;
	}
	public List<Employee> validateEmployee(String employee_name,String employee_phone) {
		entityTransaction.begin();
		String query="select e from Employee e where e.employee_name=?1 and e.employee_phone=?2 ";
		
		Query query1=entityManager.createQuery(query);
		query1.setParameter(1, employee_name);
		query1.setParameter(2, employee_phone);
		List<Employee> employees=query1.getResultList();
		//entityTransaction.commit();
		return employees;
	}
}
