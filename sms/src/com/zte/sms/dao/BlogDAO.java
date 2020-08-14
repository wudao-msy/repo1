package com.zte.sms.dao;

import java.util.List;

import com.zte.sms.entity.Blog;

public interface BlogDAO {
	
	public List<Blog> selectBlogsByPage();
	
	public List<Blog> selectBlogsByPageById(Integer sid);

	public Blog selectByTitle(String title);

	public void insertBlog(Blog blog);

	public Blog selectById(int big);

	public void updateBlog(Blog blog);

	public void deleteBlog(int big);
}
