package cn.bmy.response;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//�������ͼƬ
public class ResponseDemo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		//6.����ͷ�������������Ҫ��������
		response.setHeader("Expires","-1");
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");


		//5.֪ͨ�������ͼƬ��ʽ��
		response.setHead("Content-type","image/jpeg");

		//1���ڴ����괴��һ��ͼƬ
		BufferedImage image = new BufferedImage(20,80,BufferedImage.TYPE_INT_RGB);

		//2�õ�ͼƬ
		Graphics g = image.getGraphics();
		//����ͼƬ����ɫ
		g.setColor(Color.WHITE);
		g.fillRect(0,0,80,20);

		//3��ͼƬ��д����
		g.setColor(Color.red);
		g.setFont(null,Font.BOLD,20);
		g.drawString(makeNum(),0,20);//д��Сʵ��

		//4��ͼƬд�������
		ImageIO.write(image,"jpg",response.getOutputStream());

	}

	private String makeNum()
	{	
		//���������
		Random r = new Randow();
		//Ҫ��֤�����������������7λ
		String num = r.nextInt(9999999)+"";
		//��λ�������Ľ��в�0
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
