package com.ty.password.store.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.password.store.dao.EmployeeDao;
import com.ty.password.store.dto.Employee;

public class EmployeeControler extends  HttpServlet {

	Employee employee=new Employee();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phone=req.getParameter("phone");
		String address=req.getParameter("address");
		String gender=req.getParameter("gender");
		String role=req.getParameter("role");
		
		employee.setEmployee_name(name);
		employee.setEmployee_phone(phone);
		employee.setEmployee_address(address);
		employee.setEmployee_gender(gender);
		employee.setEmployee_role(role);
		
		EmployeeDao employeeDao=new EmployeeDao();
		Employee employees=employeeDao.saveEmployee(employee);
		PrintWriter printWriter=resp.getWriter();
		if(employees!=null) {
			printWriter.write("<html><body>");
			printWriter.write("<h1>"+ employees.getEmployee_name()+": Your Registration Complited\n Your Id is: "+employees.getEmployee_id()+" </h1>");
			printWriter.write("</html></body>");
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>Your Details Not Entered</h1>");
			printWriter.write("</html></body>");
		}
	}
	
	
}
