package cn.itcast.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.itcast.dao.StudentDao4dom4j;
import cn.itcast.domain.Student4dom4j;

public class Main4dom4j {

	public static void main(String[] args) throws IOException {
		
		System.out.println("���ѧ�� (a)  ����ѧ��(b)  ɾ��ѧ��(c)");
		System.out.print("������������ͣ�");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String type = br.readLine();
		
		if(type.equalsIgnoreCase("a")){
			//���ѧ��
			
			try{
				System.out.print("������ѧ��������");
				String name = br.readLine();
				
				System.out.print("������ѧ��׼��֤�ţ�");
				String examid = br.readLine();
				
				System.out.print("������ѧ�����֤�ţ�");
				String idcard = br.readLine();
				
				System.out.print("������ѧ�����ڵأ�");
				String location = br.readLine();
				
				System.out.print("������ѧ���ɼ���");
				String grade = br.readLine();
				
				
				Student4dom4j student = new Student4dom4j();
				student.setExamid(examid);
				student.setGrade(Double.parseDouble(grade));
				student.setIdcard(idcard);
				student.setLocation(location);
				student.setName(name);
				
				StudentDao4dom4j dao = new StudentDao4dom4j();
				dao.add(student);
				System.out.println("��ϲ��¼��ɹ�������");
			}catch (Exception e) {
				System.out.println("�Բ���¼��ʧ�ܣ���");
			}
			
			
		}else if(type.equalsIgnoreCase("b"))
		{
			//����ѧ��
			try
			{
				System.out.println("���������ѧ����ѧ���ţ�");
				String idcard = br.readLine();
				
				StudentDao4dom4j dao = new StudentDao4dom4j();
				dao.find(idcard);
				System.out.println("���ҳɹ���");
			}catch(Exception e)
			{
				System.out.println("����ʧ�ܣ�");
				
			}
			
		}
		
		else if(type.equalsIgnoreCase("c"))
		{
			//ɾ��ѧ��
			try
			{
				System.out.println("������ɾ��ѧ����������");
				String name = br.readLine();
				
				StudentDao4dom4j dao = new StudentDao4dom4j();
				dao.delete(name);
				System.out.println("ɾ���ɹ�������");
				
			}catch(Exception e)
			{
				System.out.println("ɾ��ʧ�ܣ���");
			}
			
		}
		else
		{
			System.out.println("��֧�ִ������������");
		}	
	}
}

