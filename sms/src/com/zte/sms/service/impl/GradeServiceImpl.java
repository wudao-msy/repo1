package com.zte.sms.service.impl;

import java.util.List;

import com.zte.sms.dao.GradeDAO;
import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.GradeVO;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.GradeService;

public class GradeServiceImpl implements GradeService {

	@Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		List<Grade> grades=gradeDAO.selectAll();
		return grades;
	}

	@Override
	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		gradeDAO.insertGrade(grade);
	}

	@Override
	public void modifyStatus(Grade grade) {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		gradeDAO.updateState(grade);
	}

	@Override
	public void modifyGradeById(Grade grade) {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		gradeDAO.updateGradeById(grade);
	}

	@Override
	public void removeGrade(Integer gid) {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		gradeDAO.deleteGrade(gid);
	}

	@Override
	public Grade findById(Integer gid) {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		return gradeDAO.selectById(gid);
	}

	@Override
	public List<Grade> findGradesByName(GradeVO gradeVo) {
		// TODO Auto-generated method stub
		GradeDAO  gradeDAO= (GradeDAO)ObjectFactory.getObject("gradeDAO");
		List<Grade> grades=gradeDAO.selectGradesByName(gradeVo);
		return grades;
	}

}
