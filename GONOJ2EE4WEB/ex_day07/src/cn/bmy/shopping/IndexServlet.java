package cn.bmy.shopping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//��ҳ���г�������
public class IndexServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//������������URL��дʱ����Ҫ��
		request.getSession();
		
		out.write("����վ�������飺<br/>");
		
		Set<Map.Entry<String,Book>> set = DB.getAll().entrySet();
		for(Map.Entry<String, Book> me : set)
		{
			Book book = me.getValue();
			//out.write(book.getName()+ "<a href='/ex_day07/servlet/BuyServlet?id="+book.getId()+"'>����</a><br/>"); 
			//������ĵ�ַ����URL��д
			String url = "/ex_day07/servlet/BuyServlet?id="+book.getId();
			url = response.encodeURL(url);
			out.write(book.getName()+ "<a href='"+url+"'>����</a><br/>");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
//ģ�����ݿ�
class DB	
{
	/*����һ�������һ������������������Ʒ
	������map connection
			���У� ûӴ˫�е�����ʱ���õ���
		     ˫�У��и��ݹؼ���ȥ����ֵ������ʱ
	*/
	//LinkedHashMap�������������ݽṹ���Ա�֤�洢��˳���һ���ԣ�HashMap����
	private static Map<String,Book> map = new LinkedHashMap();
	static //�򼯺���putһϵ�е��飬ֻ��Ҫһ��
	{
		map.put("1",new Book("1", "javaweb","С��","heheh"));
		map.put("2",new Book("2", "Sping","A","xixi"));
		map.put("3",new Book("3", "hibernate","B","zizi"));
		map.put("4",new Book("4", "strus","C","ffyfyf"));
		map.put("5",new Book("5", "c++","D","eeese"));
	}
	
	public static Map getAll()
	{
		return map;
	}
}

class Book
{
	private String id;
	private String name;
	private String author;
	private String description;
	
	
	public Book() {
		super();
	}
	
	public Book(String id, String name, String author, String description) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.description = description;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}