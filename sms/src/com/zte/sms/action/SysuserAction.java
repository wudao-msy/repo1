package com.zte.sms.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zte.sms.constant.Constant;
import com.zte.sms.entity.Course;
import com.zte.sms.entity.Grade;
import com.zte.sms.entity.Student;
import com.zte.sms.entity.Sysuser;
import com.zte.sms.entity.vo.StudentVO1;
import com.zte.sms.entity.vo.SysuserVO;
import com.zte.sms.exception.UserOrPassWrongException;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.CourseService;
import com.zte.sms.service.GradeService;
import com.zte.sms.service.StudentService;
import com.zte.sms.service.SysuserService;


public class SysuserAction {

	public String login(HttpServletRequest req, HttpServletResponse resp) {

		SysuserService sysuserProxy = (SysuserService) ObjectFactory.getObject("sysuserProxy");
		StudentService studentProxy = (StudentService) ObjectFactory.getObject("studentProxy");
		SysuserVO sysuserVO = new SysuserVO();
		StudentVO1 studentVo=new StudentVO1();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		sysuserVO.setUsername(username);
		sysuserVO.setPassword(password);
		String state = req.getParameter("state");
		if ("admin".equals(state)) {
			Sysuser sysuser = null;

			try {
				sysuser = sysuserProxy.findUserByUsernamePass(sysuserVO);
				req.getSession().setAttribute("user", sysuser);
			} catch (UserOrPassWrongException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("error",e.getMessage());
				return "fail";
			}
			
			return "admin";
			

		}
		else if("student".equals(state)){
			studentVo.setUsername(username);
			studentVo.setPassword(password);
			Student student=null;
			try {
				student = studentProxy.findStudentByUsernamePass(studentVo);
				req.getSession().setAttribute("stu", student);
			} catch (UserOrPassWrongException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				req.setAttribute("error",e.getMessage());
				return "fail";
			}
			
			return "student";
		}
		
		return "fail";

		
	}
	
	//修改密码
	public void modifyPwd(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		//获取请求提交过来的值
		String id = req.getParameter("id");
		String oldPass = req.getParameter("oldPassword");
		String newPass = req.getParameter("newPassword");
		SysuserService sysuserProxy = (SysuserService) ObjectFactory.getObject("sysuserProxy");
		SysuserVO sysuserVO = new SysuserVO();
		sysuserVO.setId(Integer.parseInt(id));
		sysuserVO.setPassword(oldPass);
		sysuserVO.setNewPass(newPass);
		resp.setContentType(Constant.CONTENT_TYPE);
		try {
			sysuserProxy.findUserByIdAndPass(sysuserVO);
			//根据id修改密码
			sysuserProxy.modifyPassById(sysuserVO);
			resp.getWriter().print("success");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.getWriter().print("fail");
		}
	}
	
	
		public String modifyName(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		
		//获取请求提交过来的值
		String id = req.getParameter("id");
		String username = req.getParameter("username");
		SysuserService sysuserProxy = (SysuserService) ObjectFactory.getObject("sysuserProxy");
		SysuserVO sysuserVO = new SysuserVO();
		sysuserVO.setId(Integer.parseInt(id));
		sysuserVO.setUsername(username);
		resp.setContentType(Constant.CONTENT_TYPE);
		sysuserProxy.modifyNameById(sysuserVO);
		return "adminMain";
	}
	
	
	//退出系统
	public void logOut(HttpServletRequest req,HttpServletResponse resp){
		req.getSession().removeAttribute("user");
	}
	
	//首页
	public String toAdminMain(HttpServletRequest req,HttpServletResponse resp){
		//返回首页
		return "adminMain";
	}

}
