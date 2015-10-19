package cn.bmy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.common.Constants;

public class RegsitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");		
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String introduction = request.getParameter("introduction");
		Connection conn = null;
		
		try {
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			String sql = "select user_name from user_base_info where user_name='"+userName+"'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rst = stmt.executeQuery();
			
			if(rst.next())
			{
				//提示用户：该用户信息已存在
				out.println("[LOG001]Allready exist");
			}
			
			sql = "insert into user_base_info (user_name, password, sex, age, introduction) "
				+ "values ('"+ userName +"', '" + password + "', "+ "male".equals(sex) +", "+ 
				introduction + "')";
			stmt = conn.prepareStatement(sql);
			stmt.execute();
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//提示用户，系统故障
			out.println("[SYS001]System falt.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			//提示用户，系统故障
			out.println("[SYS001]System falt.");
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
