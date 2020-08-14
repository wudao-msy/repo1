package com.zte.sms.service.impl;
import java.util.List;


import com.zte.sms.dao.BlogDAO;
import com.zte.sms.entity.Blog;
import com.zte.sms.exception.BlogTitleExistException;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.BlogService;

public class BlogServiceImpl implements BlogService{

	@Override
	public List<Blog> findBlogByPage() {
		// TODO Auto-generated method stub
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		List<Blog> blogs=blogDAO.selectBlogsByPage();
		return blogs;
	}
	
	@Override
	public List<Blog> findBlogByPageById(Integer sid) {
		// TODO Auto-generated method stub
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		List<Blog> blogs=blogDAO.selectBlogsByPageById(sid);
		return blogs;
	}

	@Override
	public Blog findByTitle(String title) throws BlogTitleExistException{
		// TODO Auto-generated method stub
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		Blog blog=blogDAO.selectByTitle(title);
		if(blog!=null){
			throw new BlogTitleExistException("blog名("+title+")已经被占用");
		}
		return blog;
	}

	@Override
	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		blogDAO.insertBlog(blog);
	}

	@Override
	public Blog findById(int big) {
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		Blog blog=blogDAO.selectById(big);
		return blog;
	}

	@Override
	public void modifyBlog(Blog blog) {
		// TODO Auto-generated method stub
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		blogDAO.updateBlog(blog);
	}

	@Override
	public void removeById(int big) {
		// TODO Auto-generated method stub
		BlogDAO blogDAO  = (BlogDAO)ObjectFactory.getObject("blogDAO");
		blogDAO.deleteBlog(big);
		
	}

}
