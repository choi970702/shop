package com.ict.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.model.AddCartCommand;
import com.ict.model.Command;
import com.ict.model.DeleteCartCommand;
import com.ict.model.EditCartCommand;
import com.ict.model.ListCommand;
import com.ict.model.OneListCommand;
import com.ict.model.ShowCartCommand;

@WebServlet("/MyController")
public class MyController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String cmd = request.getParameter("cmd");
		Command comm = null;
		if(cmd.equalsIgnoreCase("list")) 
		{
		    comm = new ListCommand();
		}else if(cmd.equalsIgnoreCase("onelist")) 
		{
			comm = new OneListCommand();
		}else if(cmd.equalsIgnoreCase("addCart")) 
		{
			comm = new AddCartCommand();
		}else if(cmd.equalsIgnoreCase("showCart")) 
		{
			comm = new ShowCartCommand();
		}else if(cmd.equalsIgnoreCase("editCart")) 
		{
			comm = new EditCartCommand();
		}else if(cmd.equalsIgnoreCase("deleteCart")) 
		{
			comm = new DeleteCartCommand();
		}
		String path = comm.exec(request, response);
		request.getRequestDispatcher(path).forward(request, response);
	}
}
