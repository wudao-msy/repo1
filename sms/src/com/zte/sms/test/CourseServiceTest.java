package com.zte.sms.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zte.sms.entity.Course;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.CourseService;

public class CourseServiceTest {

	@Test
	public void testFindAll() {
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		List<Course> courses=courseProxy.findAll();
		System.out.println(courses);
	}

	@Test
	public void testAddCourse() {
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		Course course=new Course(100,"jdaj","1214",0);
		courseProxy.addCourse(course);
	}

	@Test
	public void testModifyStatus() {
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		Course course=new Course(7,"jdaj","1214",1);
		courseProxy.modifyStatus(course);
	}

	@Test
	public void testModifyCourseById() {
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		Course course=new Course(7,"1234","1214",0);
		courseProxy.modifyCourseById(course);
	}

	@Test
	public void testRemoveCourse() {
		CourseService courseProxy = (CourseService)ObjectFactory.getObject("courseProxy");
		courseProxy.removeCourse(7);
	}

}
