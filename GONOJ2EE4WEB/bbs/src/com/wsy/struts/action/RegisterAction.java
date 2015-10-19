/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.wsy.struts.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.wsy.struts.bean.RegisterBean;
import com.wsy.struts.form.RegisterForm;
import com.wsy.struts.util.StringTrans;

/** 
 * MyEclipse Struts
 * Creation date: 11-05-2007
 * 
 * XDoclet definition:
 * @struts.action path="/registermanager" name="registerForm" input="/register.jsp" scope="request" validate="true"
 */
public class RegisterAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		ActionMessages message=new ActionMessages();
		ActionMessages error=new ActionMessages();
		DataSource datasource = getDataSource(request,"dataSources");//取struts配置的数据源
		
		String type=request.getParameter("type");
		System.out.println(type);

		RegisterForm registerForm = (RegisterForm) form;// TODO Auto-generated method stub
		if(type!=null&&type.equals("check")){
			String username=registerForm.getUsername();
		}
		StringTrans s=new StringTrans();
		String tx=registerForm.getTx();
		//System.out.println(tx);
		session.setAttribute("tx", tx);
		//取得表单中的值
		String username=registerForm.getUsername();
		String password1=registerForm.getPassword1();
		String sex=registerForm.getSex();
		String signature=registerForm.getSignature();
		String tel=registerForm.getTel();
		String qq=registerForm.getQq();
		String mail=registerForm.getMail();
		String lxdz=registerForm.getLxdz();
		String grzy=registerForm.getGrzy();
		String realname=registerForm.getRealname();
		RegisterBean r=new RegisterBean();
		
		
		//将表单中的值转码
		int i=r.InsertData(username,password1, sex, signature, tel,qq, mail,lxdz,tx,grzy,realname,datasource);
		System.out.println(i);
		session.setAttribute("registersucess", i+"");
		if(i==1){
			message.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("success.register"));
			saveErrors(request,message);
			//return mapping.findForward("success");
		}
		return mapping.getInputForward();
	}
}