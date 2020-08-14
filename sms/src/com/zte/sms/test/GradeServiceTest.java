package com.zte.sms.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zte.sms.entity.Grade;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.GradeService;

public class GradeServiceTest {

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddGrade() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testModifyGradeById() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveGrade() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testFindGradesByName() {
		GradeService gradeProxy = (GradeService)ObjectFactory.getObject("gradeProxy");
	}
	

}
