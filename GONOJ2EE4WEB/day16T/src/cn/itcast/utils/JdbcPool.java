package cn.itcast.utils;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

public class JdbcPool implements DataSource {

	private static LinkedList<Connection> list = new LinkedList<Connection>();
	
	static{
		try{
			InputStream in = JdbcPool.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			
			Class.forName(driver);
			
			for(int i=0;i<10;i++){
				Connection conn = DriverManager.getConnection(url, username, password);
				System.out.println("获取到了链接" + conn);
				list.add(conn);
			}
			
		}catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/*
	1.写一个子类，覆盖close方法
	2、写一个connection的包装类，增强close方法
	3、用动态代理，返回一个代理对象出去，拦截close方法的调用，对close进行增强
	
	
	 */
	
	public Connection getConnection() throws SQLException {
		
		//proxyConnection.commit()  proxyConnection.rollback
		if(list.size()>0){
			final Connection conn = list.removeFirst();   //myconnection.commit
			System.out.println("池大小是" + list.size());
			return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){

				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if(!method.getName().equals("close")){
						return method.invoke(conn, args);
					}else{
						list.add(conn);
						System.out.println(conn + "被还给池了！！");
						System.out.println("池大小为" + list.size());
						return null;
					}
					
				}
				
			});
			
		}else{
			throw new RuntimeException("对不起，数据库忙");
		}
		
	}

	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}
}


/*
用包装设计模式对某个对象进行增强
1.写一个类，实现与被增强对象(mysql的connection)相同的接口
2、定义一个变量，指向被增强对象
3、定义一个构造方法，接收被增强对象
4、覆盖想增强的方法
5、对于不想增强的方法，直接调用被增强对象的方法
 */

class MyConnection implements Connection{
	
	private Connection conn;
	private List pool;
	public MyConnection(Connection conn,List pool){
		this.conn = conn;
		this.pool = pool;
	}
	
	public void close() throws SQLException {
		pool.add(conn);
	}
	
	public void clearWarnings() throws SQLException {
		this.conn.clearWarnings();
		
	}
	
	public void commit() throws SQLException {
		this.conn.commit();
		
	}
	public Statement createStatement() throws SQLException {
		return this.conn.createStatement();
	}
	public Statement createStatement(int resultSetType, int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Statement createStatement(int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	public String nativeSQL(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public CallableStatement prepareCall(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public CallableStatement prepareCall(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement prepareStatement(String sql) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement prepareStatement(String sql, int[] columnIndexes)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement prepareStatement(String sql, String[] columnNames)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public PreparedStatement prepareStatement(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void releaseSavepoint(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void rollback(Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void setAutoCommit(boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void setCatalog(String catalog) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void setHoldability(int holdability) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void setReadOnly(boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public Savepoint setSavepoint(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void setTransactionIsolation(int level) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}

