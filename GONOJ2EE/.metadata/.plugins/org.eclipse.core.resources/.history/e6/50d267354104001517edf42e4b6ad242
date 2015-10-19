package com.mec.view;

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
import javax.servlet.http.HttpSession;

import com.mec.common.Constants;

/**
 * Servlet implementation class MainView
 */
public class MainView extends HttpServlet {
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
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>                                ");
		out.println("		<head>                             ");
		out.println("		<meta charset='UTF-8'>             ");
		out.println("		<title>Insert title here</title>   ");
		out.println("		</head>                            ");
		out.println("		<body>                             ");
		out.println("			<h1>Welcome to MEC Blog System</h1>  ");
		out.println("			                                 ");
		out.println("			<table border='1'>               ");
		out.println("				<thead>                        ");
		out.println("					<tr>                         ");
		out.println("						<th>blog title</th>          ");
		out.println("						<th>create time</th>          ");
		out.println("						<th>author</th>          ");
		out.println("					</tr>                        ");
		out.println("				</thead>                       ");
		out.println("				                               ");
		out.println("				<tbody>                        ");
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		
		if(userName == null){
			response.sendRedirect("./loginErrorView?errorCode=LOG003&errorMsg=You%20have%20Not%20Login");
			return;
		}
		
		String sql="select blog_title, create_time from user_blog_info where user_name = '"+ userName + "'";
		Connection conn = null;
		try {
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rst = stmt.executeQuery();
			
			while(rst.next()){
				String blogTitle = rst.getString("blog_title");
				String createTime = rst.getString("create_time");
				out.println("					<tr>                         ");
				out.println("						<td>" + blogTitle + "</td>                  ");
				out.println("						<td>" + createTime + "</td>                  ");
				out.println("						<td>" + userName + "</td>                  ");
				out.println("					</tr>                        ");				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("			</tbody>                       ");
		out.println("		</table>                         ");
		out.println("	</body>                            ");
		out.println("</html>                            ");
	}

}
