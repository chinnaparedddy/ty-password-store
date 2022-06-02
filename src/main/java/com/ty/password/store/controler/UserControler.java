 package com.ty.password.store.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.password.store.dto.User;
import com.ty.password.store.service.UserService;

public class UserControler extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		String email=req.getParameter("mail");
		String phone=req.getParameter("phone");
		String gender=req.getParameter("gender");
		String password=req.getParameter("password");
		
		User user=new User();
		
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		user.setGender(gender);
		user.setPhone(phone);
		UserService  userService=new UserService();
		User saved=userService.saveUser(user);
		PrintWriter printWriter=resp.getWriter();
		
		if(saved!=null) {
		printWriter.write("<html><body>");
		printWriter.write("<h1>Id is:"+user.getId()+"</h1>");
		printWriter.write("<h1>Name is:"+user.getName()+"</h1>");
		printWriter.write("<h1>Email is:"+user.getEmail()+"</h1>");
		printWriter.write("<h1>Phone is:"+user.getPhone()+"</h1>");
		printWriter.write("<h1>Gender is:"+user.getGender()+"</h1>");
		printWriter.write("<h1>Password is:"+user.getPassword()+"</h1>");
		printWriter.write("</body></html>");
		}else {
			printWriter.write("<html><body>");
			printWriter.write("<h1>No user Found</h1>");
			printWriter.write("</body></html>");
		}
	}

}
