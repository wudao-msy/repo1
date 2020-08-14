package com.zte.sms.service;

import java.util.List;

import com.zte.sms.entity.Course;
import com.zte.sms.entity.vo.CourseVO;

public interface CourseService {

	public List<Course> findAll();

	public void addCourse(Course course);
	
	public void modifyStatus(Course course);
	
	public void modifyCourseById(Course course);
	
	public void removeCourse(Integer cid);
	
	public Course findById(Integer cid);
	
	public List<Course> findCoursesByName(CourseVO courseVo);
}
