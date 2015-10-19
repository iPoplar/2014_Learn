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
				System.out.println("��ȡ��������" + conn);
				list.add(conn);
			}
			
		}catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	/*
	1.дһ�����࣬����close����
	2��дһ��connection�İ�װ�࣬��ǿclose����
	3���ö�̬��������һ����������ȥ������close�����ĵ��ã���close������ǿ
	
	
	 */
	
	public Connection getConnection() throws SQLException {
		
		//proxyConnection.commit()  proxyConnection.rollback
		if(list.size()>0){
			final Connection conn = list.removeFirst();   //myconnection.commit
			System.out.println("�ش�С��" + list.size());
			return (Connection) Proxy.newProxyInstance(JdbcPool.class.getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){

				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if(!method.getName().equals("close")){
						return method.invoke(conn, args);
					}else{
						list.add(conn);
						System.out.println(conn + "���������ˣ���");
						System.out.println("�ش�СΪ" + list.size());
						return null;
					}
					
				}
				
			});
			
		}else{
			throw new RuntimeException("�Բ������ݿ�æ");
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
�ð�װ���ģʽ��ĳ�����������ǿ
1.дһ���࣬ʵ���뱻��ǿ����(mysql��connection)��ͬ�Ľӿ�
2������һ��������ָ����ǿ����
3������һ�����췽�������ձ���ǿ����
4����������ǿ�ķ���
5�����ڲ�����ǿ�ķ�����ֱ�ӵ��ñ���ǿ����ķ���
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

