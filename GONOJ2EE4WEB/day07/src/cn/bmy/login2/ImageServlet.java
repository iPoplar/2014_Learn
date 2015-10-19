package cn.bmy.login2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
输出随机图片 *
 */
public class ImageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//1.在内存中创建一副图片
		BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
		
		//2.得到图片
		Graphics2D g = (Graphics2D) image.getGraphics();
		
		//设置图片背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 80, 20);
		
		//3.向图片上写数据
		g.setColor(Color.BLUE);
		g.setFont(new Font(null, Font.BOLD,20));
		String checkcode = makeNum();
		request.getSession().setAttribute("checkcode", checkcode);
		
		g.drawString(checkcode, 0, 20);
		
		//4.将图片写给浏览器
		ImageIO.write(image,"jpg",response.getOutputStream());
		
		//5.通知浏览器以图片的方式打开
		response.setHeader("Content-type", "image/jpeg");
		
		//6.设置头，控制浏览器不要缓存图片数据
		response.setHeader("Expires", "-1");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
	}

	private String makeNum()
	{
		Random r = new Random();
		String num = r.nextInt(99999)+"";
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < 7-num.length();i++)
		{
			sb.append("0");
		}
		num  = sb.toString() + num;
		return num;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
