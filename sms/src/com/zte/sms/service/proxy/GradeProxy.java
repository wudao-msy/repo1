package com.zte.sms.service.proxy;

import java.util.List;

import com.zte.sms.entity.Grade;
import com.zte.sms.entity.vo.GradeVO;
import com.zte.sms.factory.ObjectFactory;
import com.zte.sms.service.GradeService;
import com.zte.sms.transaction.TransactionManager;

public class GradeProxy implements GradeService {

	@Override
	public List<Grade> findAll() {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		List<Grade> grades=null;
		try {
			tran.beginTransaction();
			grades=gradeServcie.findAll();
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return grades;
	}

	@Override
	public void addGrade(Grade grade) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		try {
			tran.beginTransaction();
			gradeServcie.addGrade(grade);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
	}

	@Override
	public void modifyStatus(Grade grade) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		try {
			tran.beginTransaction();
			gradeServcie.modifyStatus(grade);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
	}

	@Override
	public void modifyGradeById(Grade grade) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		try {
			tran.beginTransaction();
			gradeServcie.modifyGradeById(grade);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
	}

	@Override
	public void removeGrade(Integer gid) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		try {
			tran.beginTransaction();
			gradeServcie.removeGrade(gid);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
	}

	@Override
	public Grade findById(Integer gid) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		Grade grade=null;
		try {
			tran.beginTransaction();
			grade=gradeServcie.findById(gid);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return grade;
	}

	@Override
	public List<Grade> findGradesByName(GradeVO gradeVo) {
		// TODO Auto-generated method stub
		TransactionManager tran=(TransactionManager)ObjectFactory.getObject("transaction");
		GradeService gradeServcie = (GradeService)ObjectFactory.getObject("gradeService");
		List<Grade> grades=null;
		try {
			tran.beginTransaction();
			grades=gradeServcie.findGradesByName(gradeVo);
			tran.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tran.rollback();
		}
		return grades;
	}

}
