package com.zte.sms.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.zte.sms.constant.Constant;
import com.zte.sms.entity.Blog;
import com.zte.sms.entity.Course;
import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.BlogVO;
import com.zte.sms.entity.vo.PageInfo;
import com.zte.sms.exception.BlogTitleExistException;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.BlogService;
import com.zte.sms.service.CourseService;
import com.zte.sms.service.GradeService;


public class BlogAction {
	
	public String toBlogManager(HttpServletRequest req,HttpServletResponse resp){
		//显示添加学生页面
		return "toBlogManager";
	}
	
	public void findBlogsByPage(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//获取记录
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
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
		List<Blog> blogs = blogProxy.findBlogByPage();
		PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);
		resp.setContentType(Constant.CONTENT_TYPE);
		resp.getWriter().print(JSON.toJSON(pageInfo));
	}
	
	
	public void findBlogsByPageById(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		//获取记录
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
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
		int sid=Integer.parseInt("sid");
		
		List<Blog> blogs = blogProxy.findBlogByPageById(sid);
		PageInfo<Blog> pageInfo = new PageInfo<Blog>(blogs);
		resp.setContentType(Constant.CONTENT_TYPE);
		resp.getWriter().print(JSON.toJSON(pageInfo));
	}
	
	public String addBlog(HttpServletRequest request,HttpServletResponse response){
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
		Blog blog=new Blog();
		int sid=Integer.parseInt(request.getParameter("sid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		blog.setTitle(title);
		blog.setContent(content);
		blog.setCreateDate(new Date());
		blog.setSid(sid);
		blogProxy.addBlog(blog);
		return "toStudentBlog";
	}
	
	public void findById(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType(Constant.CONTENT_TYPE);
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
		int bid=Integer.parseInt(request.getParameter("bid"));
		Blog blog=blogProxy.findById(bid);
		response.getWriter().print(JSON.toJSON(blog));
		
	}
	
	public void findByTitle(HttpServletRequest request,HttpServletResponse response) throws  BlogTitleExistException, IOException{
		response.setContentType(Constant.CONTENT_TYPE);
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
		String title=request.getParameter("title");
		Blog blog=blogProxy.findByTitle(title);
		
		response.getWriter().print(JSON.toJSON(blog));
		
	}
	
	public String modifyBlog(HttpServletRequest request,HttpServletResponse response){
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
		int bid=Integer.parseInt(request.getParameter("bid"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		Blog blog=new Blog(bid,title,content,new Date(),null);
		blogProxy.modifyBlog(blog);
		return "toStudentBlog";
	}
	
	public String deleteBlog(HttpServletRequest request,HttpServletResponse response){
		int bid=Integer.parseInt(request.getParameter("bid"));
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
		blogProxy.removeById(bid);
		request.setAttribute("msg", "删除成功");
		return "toBlogManager";
	}
	
	public String deleteBlog1(HttpServletRequest request,HttpServletResponse response){
		int bid=Integer.parseInt(request.getParameter("bid"));
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");
		blogProxy.removeById(bid);
		request.setAttribute("msg", "删除成功");
		return "toStudentBlog";
	}
	
	public String toStudentMain(HttpServletRequest request,HttpServletResponse response){
		GradeService gradeProxy = (GradeService) ObjectFactory.getObject("gradeProxy");
		CourseService courseProxy = (CourseService) ObjectFactory.getObject("courseProxy");
		List<Grade> gradeList = gradeProxy.findAll();
		List<Course> courseList = courseProxy.findAll();
		request.setAttribute("gradeList", gradeList);
		request.setAttribute("courseList", courseList);
		return "toblogMain";
	}
	
	public String toStudentBlog(HttpServletRequest request,HttpServletResponse response){
		
		return "toStudentBlog";
	}
	
	public String toNewBlog(HttpServletRequest request,HttpServletResponse response){
		
		return "toNewBlog";
	}
}
