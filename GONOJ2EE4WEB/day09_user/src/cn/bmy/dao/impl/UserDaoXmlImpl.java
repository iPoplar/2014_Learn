package cn.bmy.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import cn.bmy.dao.UserDao;
import cn.bmy.domain.User;
import cn.bmy.utils.XmlUtils;

//根据业务需求来
public class UserDaoXmlImpl implements UserDao 
{
	public User find(String username, String password)
	{
		try
		{
			//selectSingleNode匹配查询的一个单独的 Node
			Document document = XmlUtils.getDocument();
			Element e = (Element) document
					.selectSingleNode("//user[@username='" + username
							+ "' and@password='" + password + "']");
			if (e == null)
			{
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birth));
			
			return user;
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public void add(User user)
	{
		try 
		{
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			Element user_node = root.addElement("user");
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("id", user.getId());
			user_node.setAttributeValue("username", user.getUsername());
			user_node.setAttributeValue("password", user.getPassword());
			user_node.setAttributeValue("email", user.getEmail());
			user_node.setAttributeValue("birthday", user.getBirthday()
					.toLocaleString());
			XmlUtils.write2Xml(document);
		} catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}

	public User find(String username)
	{
		try 
		{
			Document document = XmlUtils.getDocument();
			Element e = (Element) document.selectSingleNode("//user[@username'"
					+ username + "']");
			if(e==null)
			{
				return null;
			}
			User user = new User();
			user.setId(e.attributeValue("id"));
			user.setEmail(e.attributeValue("email"));
			user.setPassword(e.attributeValue("password"));
			user.setUsername(e.attributeValue("username"));
			String birth = e.attributeValue("birthday");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			user.setBirthday(sdf.parse(birth));
			
			return user;
		} catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
	}
}
