package com.zte.sms.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zte.sms.constant.Constant;
import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.GradeVO;
import com.zte.sms.entity.vo.PageInfo;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.GradeService;


public class GradeAction {
	
	public String toGradeManager(HttpServletRequest req,HttpServletResponse resp){
		//显示添加学生页面
		return "toGradeManager";
	}
	
	public void findGradesByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//获取记录
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		String pageNoStr = req.getParameter("pageNo");
		String pageSizeStr = req.getParameter("pageSize");
		int pageNo=0;
		int pageSize=0;
		if(pageNoStr==null){
			pageNo=Constant.PAGE_NO;
		}
		else{
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageSizeStr==null){
			pageSize=Constant.PAGE_SIZE;
		}
		else{
			pageSize=Integer.parseInt(pageSizeStr);
		}
		
		PageHelper.startPage(pageNo, pageSize);
		List<Grade> grades = gradeProxy.findAll();
		PageInfo<Grade> pageInfo = new PageInfo<Grade>(grades);
		resp.setContentType(Constant.CONTENT_TYPE);
		resp.getWriter().print(JSON.toJSON(pageInfo));
	}
	
	public String addGrade(HttpServletRequest request,HttpServletResponse response){
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		Grade grade=new Grade();
		String gname=request.getParameter("gname");
		String gdesc=request.getParameter("gdesc");
		grade.setGid(null);
		grade.setGname(gname);
		grade.setGdesc(gdesc);
		grade.setState(Integer.parseInt(Constant.GRADE_STATUS_ENABLE));
		gradeProxy.addGrade(grade);
		return "toGradeManager";
	}
	
	public String modifyStatusTo0(HttpServletRequest request,HttpServletResponse response){
		int gid=Integer.parseInt(request.getParameter("gid"));
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		Grade grade=new Grade();
		grade.setGid(gid);
		grade.setState(Integer.parseInt(Constant.GRADAE_STATUS_DISABLE));
		gradeProxy.modifyStatus(grade);
		return "toGradeManager";
	}
	
	public String modifyStatusTo1(HttpServletRequest request,HttpServletResponse response){
		int gid=Integer.parseInt(request.getParameter("gid"));
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		Grade grade=new Grade();
		grade.setGid(gid);
		grade.setState(Integer.parseInt(Constant.GRADE_STATUS_ENABLE));
		gradeProxy.modifyStatus(grade);
		return "toGradeManager";
	}
	
	public void findById(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType(Constant.CONTENT_TYPE);
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		int gid=Integer.parseInt(request.getParameter("gid"));
		Grade grade=gradeProxy.findById(gid);
		response.getWriter().print(JSON.toJSON(grade));
		
	}
	
	public String modifyGrade(HttpServletRequest request,HttpServletResponse response){
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		int gid=Integer.parseInt(request.getParameter("gid"));
		String gname=request.getParameter("gname");
		String gdesc=request.getParameter("gdesc");
		Grade grade=new Grade(gid,gname,gdesc,null);
		gradeProxy.modifyGradeById(grade);
		return "toGradeManager";
	}
	
	public String deleteGrade(HttpServletRequest request,HttpServletResponse response){
		int gid=Integer.parseInt(request.getParameter("gid"));
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		gradeProxy.removeGrade(gid);
		request.setAttribute("msg", "删除成功");
		return "toGradeManager";
	}
	
	public void findByCondition(HttpServletRequest request,HttpServletResponse response) throws IOException{
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
		String pageNoStr = request.getParameter("pageNo");
		String pageSizeStr = request.getParameter("pageSize");
		int pageNo=0;
		int pageSize=0;
		if(pageNoStr==null){
			pageNo=Constant.PAGE_NO;
		}
		else{
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageSizeStr==null){
			pageSize=Constant.PAGE_SIZE;
		}
		else{
			pageSize=Integer.parseInt(pageSizeStr);
		}
		
		PageHelper.startPage(pageNo, pageSize);
		List<Grade> grades=null;
		String gname=request.getParameter("gname");
		if(""==gname||gname==null){
			grades = gradeProxy.findAll();
		}else{
			GradeVO gradeVo=new GradeVO();
			gradeVo.setGname("%"+gname+"%");
			grades = gradeProxy.findGradesByName(gradeVo);
		}
		PageInfo<Grade> pageInfo = new PageInfo<Grade>(grades);
		response.setContentType(Constant.CONTENT_TYPE);
		response.getWriter().print(JSON.toJSON(pageInfo));
	}
}
