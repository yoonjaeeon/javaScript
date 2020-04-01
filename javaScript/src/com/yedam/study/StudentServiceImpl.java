package com.yedam.study;

import java.util.List;

public class StudentServiceImpl implements StudentService {

	EmpDAO dao = new EmpDAO();

	@Override
	public List<Student> getStudList() {
		// TODO Auto-generated method stub
		return dao.getEmpList();
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
