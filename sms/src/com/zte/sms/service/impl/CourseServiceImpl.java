package com.zte.sms.service.impl;

import java.util.List;

import com.zte.sms.dao.CourseDAO;
import com.zte.sms.entity.Course;
import com.zte.sms.entity.vo.CourseVO;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.CourseService;

public class CourseServiceImpl implements CourseService {

	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		List<Course> courses=courseDAO.selectAll();
		return courses;
	}

	@Override
	public void addCourse(Course course) {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		courseDAO.insertCourse(course);
	}

	@Override
	public void modifyStatus(Course course) {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		courseDAO.updateState(course);
	}

	@Override
	public void modifyCourseById(Course course) {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		courseDAO.updateCourseById(course);
	}

	@Override
	public void removeCourse(Integer cid) {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		courseDAO.deleteCourse(cid);
	}

	@Override
	public Course findById(Integer cid) {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		return courseDAO.selectById(cid);
	}

	@Override
	public List<Course> findCoursesByName(CourseVO courseVo) {
		// TODO Auto-generated method stub
		CourseDAO  courseDAO = (CourseDAO)ObjectFactory.getObject("courseDAO");
		List<Course> courses=courseDAO.selectCoursesByName(courseVo);
		return courses;
	}

}
