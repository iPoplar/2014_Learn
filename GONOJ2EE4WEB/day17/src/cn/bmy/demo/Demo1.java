package cn.bmy.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.bmy.domain.User;
import cn.bmy.utils.JdbcUtils;

/**
 * ʹ��dbutils���curd�Ѿ�������
 */
public class Demo1 
{
	@Test
	//ʹ�����ݿ����ӳؽ�����ɾ�Ĳ飬����Ҫ�������Ĺ���
	public void add() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into user(name,password,email,birthday)values(?,?,?,?)";
		Object params[] = { "ccc", "123", "cc@sina.com", new Date() };
		qr.update(sql, params);
		
	}

	@Test
	public void delete() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "delete from user where id=?";
		qr.update(sql, 5);
	}

	@Test
	public void update() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "update user set name=? where id=?";
		Object params[] = {"xiao",4};
		qr.update(sql, params);
	}
	
	@Test
	public void getAll() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		List list = (List) qr.query(sql, new BeanListHandler(User.class));
		System.out.println(list.size());
	}
	
	@Test//������
	public void testBatch() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		//String sql = "insert into user(name,password,email,birthday)values(?,?,?,?)";
		String sql = "delete from user where id=?";
		Object params[][] = new Object[30][];
		//****
		System.out.println("***"+params.length);
		for(int i=0; i < params.length; i++)
		{
			//params[i] = new Object[]{"xxix" +i , "111","xiaob@xi.com", new Date()};
			params[i]=new Object[]{i};
		}
		qr.batch(sql, params);
	}
	
	// ��dbutils��ɴ����ݣ��������ã�
	/***************************************************************************
	 create table testclob
	 (
	 	id int primary key auto_increment,
	 	resume text
	 );
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws SerialException 
	 **************************************************************************/
	@Test
	public void testclob() throws IOException, SerialException, SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "insert into testclob(resume) values(?)";
		
		/*//�滻����
		String path = Demo1.class.getClassLoader().getResource("test1.txt").getPath();
		Object params[] = {new FileReader(path)};
		*/
		String path = Demo1.class.getClassLoader().getResource("test1.txt").getPath();
		FileReader in = new FileReader(path);
		char[] buffer = new char[(int) new File(path).length()];
		
		in.read(buffer);
		SerialClob clob = new SerialClob(buffer);
		Object params[] = {clob}; //������������
		qr.update(sql, params);
	}
	
}
