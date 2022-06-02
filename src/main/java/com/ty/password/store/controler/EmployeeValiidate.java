package com.ty.password.store.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.password.store.dto.Employee;
import com.ty.password.store.service.EmployeeService;

public class EmployeeValiidate extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("name");
		String phone=req.getParameter("phone");
		
		EmployeeService employeeService=new EmployeeService();
		List<Employee> employees=employeeService.validateEmployee(email, phone);
		PrintWriter printWriter=resp.getWriter();
		if(employees!=null) {
			for(Employee employee:employees) {
			printWriter.write("<html><body>");
			printWriter.write("<h1>WelCome "+employee.getEmployee_name()+"</h1>");
			printWriter.write("</body></html>");
			}
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>name and phone not valid</h1>");
			printWriter.write("</body></html>");
		}
	}
}
