package cn.bmy.demo;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import cn.bmy.utils.JdbcUtils;

public class Demo2
{
	/**
	 * 测试dbUtils中各种处理器
	 * @throws SQLException 
	 */
	@Test
	public void testArrayHandler() throws SQLException
	{
		//生成连接池的工具
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		Object result[] = (Object[]) qr.query(sql, new ArrayHandler());
		//Arrays.asList();返回一个指定数组支持的固定大小的列表
		System.out.println(Arrays.asList(result));
	}
	
	@Test
	public void testArrayListHandler() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		List<Object[]> list  = (List<Object[]>) qr.query(sql, new ArrayListHandler());
		for(Object[] ls : list)
		{
			System.out.println(Arrays.asList(ls));
		}
	}
	
	@Test
	public void testColumnListHandler() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		List list = (List) qr.query(sql, new ColumnListHandler("name"));
		System.out.println(Arrays.asList(list));
	}
	
	@Test
	public void testKeyedHandler() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		Map<Integer, Map> map = (Map) qr.query(sql, new KeyedHandler("id"));
		for(Map.Entry<Integer, Map> me : map.entrySet())
		{
			int id = me.getKey();
			Map<String,Object> innermap = me.getValue();
			System.out.println("######"+ innermap);
			for(Map.Entry<String, Object> innerme : innermap.entrySet())
			{
				String columnName = innerme.getKey();
				Object value = innerme.getValue();
				System.out.println(columnName + "=" + value);
			}
		}
	}

	/*输出结果：
	 * ######{password=111, email=xiaob@xi.com, name=xxix0, id=30, birthday=2014-11-24}
		password=111
		email=xiaob@xi.com
		name=xxix0
		id=30
	 */
	
	@Test
	public void testMapHandler() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		
		Map<String, Object> map = (Map) qr.query(sql, new MapHandler());
		for(Map.Entry<String, Object> me : map.entrySet())
		{
			System.out.println(me.getKey() + "=" + me.getValue());
		}
		
	}
	
	@Test
	public void testMapListHandler() throws SQLException
	{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql  = "select * from user";
		List<Map> list = (List) qr.query(sql, new MapListHandler());
		
		for(Map<String,Object> map : list)
		{
			for(Map.Entry<String, Object>me : map.entrySet())
			{
				System.out.println(me.getKey() + "=" + me.getValue());
			}
		}
	}
	
	@Test
	public void testScalarHandler() throws SQLException
	{
		//TODO 有异常
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from user";
		/*int count = ((Long)qr.query(sql, new ScalarHandler(1))).intValue();
		System.out.println(count);*/
		
		/*long l = (Long) qr.query(sql, new ScalarHandler(1));
		int count = (int) l;
		
		count = Integer.parseInt(qr.query(sql, new ScalarHandler(1)).toString());
		System.out.println(count);*/
		
	}
}

