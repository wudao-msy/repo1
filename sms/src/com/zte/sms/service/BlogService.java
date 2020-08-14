package com.zte.sms.service;

import java.util.List;

import com.zte.sms.entity.Blog;
import com.zte.sms.exception.BlogTitleExistException;

public interface BlogService {
	
	public List<Blog> findBlogByPage();
	
	public List<Blog> findBlogByPageById(Integer sid);

	public Blog findByTitle(String title) throws BlogTitleExistException;

	public void addBlog(Blog blog);

	public Blog findById(int big);

	public void modifyBlog(Blog blog);

	public void removeById(int big);
	

}
