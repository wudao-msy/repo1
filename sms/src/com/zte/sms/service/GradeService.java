package com.zte.sms.service;

import java.util.List;

import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.GradeVO;

public interface GradeService {

	public List<Grade> findAll();

	public void addGrade(Grade grade);
	
	public void modifyStatus(Grade grade);
	
	public void modifyGradeById(Grade grade);
	
	public void removeGrade(Integer gid);

	public Grade findById(Integer gid);
	
	public List<Grade> findGradesByName(GradeVO gradeVo);
}
