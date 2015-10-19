package com.mec.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mec.common.Constants;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		Connection conn = null;
		try {
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			
			String sql = "select user_name, password from user_base_info where user_name = '"+
						userName
					+"'"; // 这是一个查询语句
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			
			if(!rst.next()){
				//查无此人
				response.sendRedirect("../view/loginErrorView?errorCode=LOG001&errorMsg=No%20User");
				return;
			}
			
			if(!password.equals(rst.getString("password"))){
				//密码错误
				response.sendRedirect("../view/loginErrorView?errorCode=LOG002&errorMsg=Password%20Wrong");
				return;
			}
			
			//登陆成功
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			response.sendRedirect("../main/main.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			response.sendRedirect("../view/loginErrorView?errorCode=SYS001&errorMsg=System%20Falt");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("../view/loginErrorView?errorCode=SYS001&errorMsg=System%20Falt");
		} finally{
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
