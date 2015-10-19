package com.mec.view.errorMsg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistErrorView
 */
public class LoginErrorView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorCode = request.getParameter("errorCode");
		String errorMsg = request.getParameter("errorMsg");
		String html = "<!DOCTYPE html>" +
			"<html>" +
			"<head>" +
			"<script type='text/javascript'>"
			+ " function onBtnBackToLoginClick(){"
			+ "		window.location = '../index.html';"
			+ "}"
			+ "</script>" +
			"<meta charset='UTF-8'>" +
			"<title>Insert title here</title>" +
			"</head>" +
			"<body>";
		
			if(!"000000".equals(errorCode)){
				html += "Regist Failure[" + errorCode + "]" + errorMsg;
				html += "<input type='button' value='ReLogin' onclick='onBtnBackToLoginClick();'/>";
			}
			
			html += "</body>" +
			"</html>" ;
		
		PrintWriter out = response.getWriter();
		
		out.println(html);
	}
}
