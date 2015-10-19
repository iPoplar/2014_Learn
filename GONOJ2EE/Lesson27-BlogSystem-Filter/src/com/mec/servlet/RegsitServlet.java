package com.mec.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mec.common.Constants;

/**
 * Servlet implementation class RegsitServlet
 */
public class RegsitServlet extends HttpServlet {
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
		/*Enumeration names = request.getParameterNames();
		PrintWriter out = response.getWriter();
		
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			out.println(name);
		}
		*/
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String introduction = request.getParameter("introduction");
		out.println("<meta charset='UTF-8'>");
		Connection conn = null;
		try {
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			String sql = "select user_name from user_base_info where user_name = '"+ userName +"'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rst = stmt.executeQuery();
			
			if(rst.next()){
				//提示用户：该用户信息已存�?
				//out.println("[LOG001]Allready exist");
				response.sendRedirect("../view/registErrorView?errorCode=LOG001&errorMsg=Allready%20exist");
				return;
			}
			
			sql = "insert into user_base_info (user_name, password, sex, age, introduction) "
					+ "values ('"+ userName +"', '" + password + "', "+ "male".equals(sex) +", "+ 
					new Integer(age) +", '"+ introduction + "')";
			stmt = conn.prepareStatement(sql);
			stmt.execute();
			
			//提示用户，注册成�?
			//out.println("[SUCCESS]Regist done.");
			response.sendRedirect("../view/registErrorView?errorCode=000000&errorMsg=SUCCESS");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//提示用户，系统故�?
			//out.println("[SYS001]System falt.");
			response.sendRedirect("../view/registErrorView?errorCode=SYS001&errorMsg=System%20falt.");
		} catch (SQLException e) {
			e.printStackTrace();
			//提示用户，系统故�?
			//out.println("[SYS001]System falt.");
			response.sendRedirect("../view/registErrorView?errorCode=SYS001&errorMsg=System%20falt.");
		} finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
