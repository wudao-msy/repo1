package com.zte.sms.dao;

import java.util.List;

import com.zte.sms.entity.Course;
import com.zte.sms.entity.vo.CourseVO;

public interface CourseDAO {

	List<Course> selectAll();
	
	public void insertCourse(Course course);
	
	public void updateState(Course course);
	
	public void updateCourseById(Course course);
	
	public void deleteCourse(Integer cid);
	
	Integer selectIdByName(String stringCellValue);
	
	public Course selectById(Integer cid);
	
	public List<Course> selectCoursesByName(CourseVO courseVo);
}
