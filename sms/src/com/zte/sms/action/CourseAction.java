package com.zte.sms.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zte.sms.constant.Constant;
import com.zte.sms.entity.Course;
import com.zte.sms.entity.vo.CourseVO;
import com.zte.sms.entity.vo.PageInfo;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.CourseService;


public class CourseAction {
	
	public String toCourseManager(HttpServletRequest req,HttpServletResponse resp){
		//显示添加学生页面
		return "toCourseManager";
	}
	
	public void findCoursesByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//获取记录
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
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
		List<Course> courses = courseProxy.findAll();
		PageInfo<Course> pageInfo = new PageInfo<Course>(courses);
		resp.setContentType(Constant.CONTENT_TYPE);
		resp.getWriter().print(JSON.toJSON(pageInfo));
	}
	
	public String addCourse(HttpServletRequest request,HttpServletResponse response){
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		Course course=new Course();
		String cname=request.getParameter("cname");
		String cdesc=request.getParameter("cdesc");
		course.setCid(null);
		course.setCname(cname);
		course.setCdesc(cdesc);
		course.setState(Integer.parseInt(Constant.GRADE_STATUS_ENABLE));
		courseProxy.addCourse(course);
		return "toCourseManager";
	}
	
	public void findById(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType(Constant.CONTENT_TYPE);
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		int cid=Integer.parseInt(request.getParameter("cid"));
		Course course=courseProxy.findById(cid);
		response.getWriter().print(JSON.toJSON(course));
		
	}
	
	public String modifyCourse(HttpServletRequest request,HttpServletResponse response){
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		int cid=Integer.parseInt(request.getParameter("cid"));
		String cname=request.getParameter("cname");
		String cdesc=request.getParameter("cdesc");
		Course course=new Course(cid,cname,cdesc,null);
		courseProxy.modifyCourseById(course);
		return "toCourseManager";
	}
	
	public String deleteCourse(HttpServletRequest request,HttpServletResponse response){
		int cid=Integer.parseInt(request.getParameter("cid"));
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		courseProxy.removeCourse(cid);
		request.setAttribute("msg", "删除成功");
		return "toCourseManager";
	}
	
	public void findByCondition(HttpServletRequest request,HttpServletResponse response) throws IOException{
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
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
		List<Course> courses=null;
		String cname=request.getParameter("cname");
		if(""==cname||cname==null){
			courses = courseProxy.findAll();
		}else{
			CourseVO courseVo=new CourseVO();
			courseVo.setCname("%"+cname+"%");
			courses = courseProxy.findCoursesByName(courseVo);
		}
		PageInfo<Course> pageInfo = new PageInfo<Course>(courses);
		response.setContentType(Constant.CONTENT_TYPE);
		response.getWriter().print(JSON.toJSON(pageInfo));
	}
}
