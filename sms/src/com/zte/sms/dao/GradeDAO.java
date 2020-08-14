package com.zte.sms.dao;

import java.util.List;

import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.GradeVO;

public interface GradeDAO {

	public List<Grade> selectAll();
	
	public void insertGrade(Grade grade);
	
	public void updateState(Grade grade);
	
	public void updateGradeById(Grade grade);
	
	public void deleteGrade(Integer gid);
	
	public Integer selectIdByName(String stringCellValue);
	
	public Grade selectById(Integer gid);
	
	public List<Grade> selectGradesByName(GradeVO gradeVo);
}
