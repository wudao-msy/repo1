package com.zte.sms.service.proxy;

import java.util.List;

import com.zte.sms.entity.Course;
import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.CourseVO;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.CourseService;
import com.zte.sms.service.GradeService;
import com.zte.sms.transaction.TransactionManager;

public class CourseProxy implements CourseService {

	@Override
	public List<Course> findAll() {
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
		List<Course> courses=null;
		try {
			tran.beginTransaction();
			courses=courseServcie.findAll();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return courses;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
		try {
			tran.beginTransaction();
			courseServcie.addCourse(course);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
	}

	@Override
	public void modifyStatus(Course course) {
		// TODO Auto-generated method stub
				TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
				CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
				try {
					tran.beginTransaction();
					courseServcie.modifyStatus(course);
					tran.commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					tran.rollback();
				}
	}

	@Override
	public void modifyCourseById(Course course) {
		// TODO Auto-generated method stub
				TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
				CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
				try {
					tran.beginTransaction();
					courseServcie.modifyCourseById(course);
					tran.commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					tran.rollback();
				}
	}

	@Override
	public void removeCourse(Integer cid) {
		// TODO Auto-generated method stub
				TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
				CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
				try {
					tran.beginTransaction();
					courseServcie.removeCourse(cid);
					tran.commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					tran.rollback();
				}
	}

	@Override
	public Course findById(Integer cid) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
		Course course=null;
		try {
			tran.beginTransaction();
			course=courseServcie.findById(cid);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}	
		return course;
	}

	@Override
	public List<Course> findCoursesByName(CourseVO courseVo) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		CourseService courseServcie = (CourseService)ObjectFactory.getObject("courseService");
		List<Course> courses=null;
		try {
			tran.beginTransaction();
			courses=courseServcie.findCoursesByName(courseVo);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return courses;
	}

}
