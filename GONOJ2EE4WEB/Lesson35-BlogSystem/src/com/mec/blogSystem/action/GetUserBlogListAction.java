package com.mec.blogSystem.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mec.blogSystem.model.BlogInfo;
import com.opensymphony.xwork2.ActionContext;

public class GetUserBlogListAction extends BaseAction {
	private ArrayList<BlogInfo> blogList;
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	//ArrayList<ArrayList<String>> get
	public ArrayList<BlogInfo> getBlogList(){
		return blogList;
	}
	
	public String execute() throws Exception{
		this.blogList = new ArrayList<BlogInfo>();
		
		System.out.println("1 Get session : " + this.getSession());
		System.out.println("2 Get session : " + ActionContext.getContext().getSession());
		
		
		this.userName = this.getSession().get("userName") + "";
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection conn = DriverManager.getConnection("jdbc:odbc:BlogServerDb");
		String sql = "select blog_title, create_time from user_blog_info where user_name = '"+ userName +"'";
		System.out.println(sql);
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rst = stmt.executeQuery();
		int i = 0;
		while(rst.next()){
			BlogInfo blog = new BlogInfo();
			Thread.sleep(1000);
			String blogTitle = rst.getString("blog_title");
			String createTime = rst.getString("create_time");
			blog.setBlogTitle(blogTitle);
			blog.setCreateTime(createTime);
			
			this.blogList.add(blog);
			i++;
		}
		return "RETURN";
	}
	
	@Override
	public String getErrorCode() {
		// TODO Auto-generated method stub
		return super.getErrorCode();
	}

	@Override
	public String getErrorMsg() {
		// TODO Auto-generated method stub
		return super.getErrorMsg();
	}

	public GetUserBlogListAction(){
		super();
	}
}
