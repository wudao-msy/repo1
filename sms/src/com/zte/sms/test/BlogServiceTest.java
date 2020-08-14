package com.zte.sms.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.zte.sms.entity.Blog;
import com.zte.sms.exception.BlogTitleExistException;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.BlogService;
public class BlogServiceTest {

	@Test
	public void testFindBlogByPage() {
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");	
		List<Blog> blogs=blogProxy.findBlogByPage();
		for(Blog blog:blogs){
			System.out.println(blog);
		}
	}

	@Test
	public void testFindByTitle() throws BlogTitleExistException {
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");		
		Blog blog=blogProxy.findByTitle("慎选程序设计语言");
		System.out.println(blog);
	}

	@Test
	public void testAddBlog() {
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");		
		Blog blog=new Blog();
		blog.setTitle("123");
		blog.setContent("123");
		blog.setCreateDate(new Date());
		blog.setSid(1);
		blogProxy.addBlog(blog);
	}

	@Test
	public void testFindById() {
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");		
		Blog blog=blogProxy.findById(1);
		System.out.println(blog);
	}

	@Test
	public void testModifyBlog() {
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");		
		Blog blog=new Blog();
		blog.setBid(11);
		blog.setTitle("1234");
		blog.setContent("1234");
		blog.setCreateDate(new Date());
		blog.setSid(2);
		blogProxy.modifyBlog(blog);
	}

	@Test
	public void testRemoveById() {
		BlogService blogProxy = (BlogService)ObjectFactory.getObject("blogProxy");	
		blogProxy.removeById(11);
		
	}

}
