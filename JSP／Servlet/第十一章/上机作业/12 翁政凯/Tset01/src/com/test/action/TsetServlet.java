package com.test.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.test.encity.User;

public class TsetServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("get");
		PrintWriter out = response.getWriter();
		String parameter = (String)request.getParameter("opr");
		String result = null;
		if("1231.com".equals(parameter)){
			 result = "face";
		}else{
			result = "cafg";
		}
		out.print(result);
		
		out.flush();
		out.close();
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("post");
		String parameter = (String)request.getParameter("opr");
		String result = null;
		if("1231.com".equals(parameter)){
			 result = "face";
		}else{
			result = "cafg";
		}
		out.print(result);
		out.flush();
		out.close();
	}

}
