package com.zte.sms.service.proxy;

import java.io.File;
import java.util.List;

import com.zte.sms.entity.Blog;
import com.zte.sms.entity.vo.BlogVO;
import com.zte.sms.exception.BlogTitleExistException;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.BlogService;
import com.zte.sms.transaction.TransactionManager;

public class BlogProxy implements BlogService{

	@Override
	public List<Blog> findBlogByPage() {
		// TODO Auto-generated method stub
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		List<Blog> blogs=null;
		try {
			tran.beginTransaction();
			blogs=blogService.findBlogByPage();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return blogs;
	}
	
	@Override
	public List<Blog> findBlogByPageById(Integer sid) {
		// TODO Auto-generated method stub
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		List<Blog> blogs=null;
		try {
			tran.beginTransaction();
			blogs=blogService.findBlogByPageById(sid);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return blogs;
	}

	@Override
	public Blog findByTitle(String title) throws BlogTitleExistException {
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		Blog blog=null;
		try {
			tran.beginTransaction();
			blog=blogService.findByTitle(title);
			tran.commit();
		} catch (BlogTitleExistException e) {
			// TODO: handle exception
			throw e;
		}
		return blog;
	}

	@Override
	public void addBlog(Blog blog) {
		// TODO Auto-generated method stub
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		try {
			tran.beginTransaction();
		    blogService.addBlog(blog);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		
		
	}

	@Override
	public Blog findById(int sid) {
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		Blog blog=null;
		try {
			tran.beginTransaction();
			blog=blogService.findById(sid);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
		return blog;
	}

	@Override
	public void modifyBlog(Blog blog) {
		// TODO Auto-generated method stub
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		try {
			tran.beginTransaction();
		    blogService.modifyBlog(blog);
			tran.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tran.rollback();
		}
	}

	@Override
	public void removeById(int sid) {
		// TODO Auto-generated method stub
		TransactionManager tran = (TransactionManager)ObjectFactory.getObject("transaction");
		BlogService blogService=(BlogService)ObjectFactory.getObject("blogService");
		try {
			tran.beginTransaction();
		    blogService.removeById(sid);
			tran.commit();
		} catch (Exception e) {
//			e.printStackTrace();
			tran.rollback();
			//需要向外部抛出异常，将异常交给action层处理
			throw new RuntimeException("删除失败");
		}
	}

	

}
