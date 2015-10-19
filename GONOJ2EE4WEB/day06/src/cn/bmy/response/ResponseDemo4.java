package cn.bmy.response;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//随机生成图片
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//6.设置头、控制浏览器不要缓存数据
		response.setHeader("Expires","-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");


		//5.通知浏览器以图片方式打开
		response.setHead("Content-type","image/jpeg");

		//1在内存中年创建一幅图片
		BufferedImage image = new BufferedImage(20,80,BufferedImage.TYPE_INT_RGB);

		//2得到图片
		Graphics g = image.getGraphics();
		//设置图片背景色
		g.setColor(Color.WHITE);
		g.fillRect(0,0,80,20);

		//3向图片上写数据
		g.setColor(Color.red);
		g.setFont(null,Font.BOLD,20);
		g.drawString(makeNum(),0,20);//写的小实验

		//4将图片写给浏览器
		ImageIO.write(image,"jpg",response.getOutputStream());

	}

	private String makeNum()
	{	
		//生成随机数
		Random r = new Randow();
		//要保证产生的随机数必须是7位
		String num = r.nextInt(9999999)+"";
		//对位数不够的进行补0
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<7-num.length();i++)
		{
			sb.append("0");
		}
		num = sb.toString()+num;

		return num;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
