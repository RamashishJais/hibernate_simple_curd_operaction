package com.jsp.hibernate_curd_dto_service_controller.Service;

import java.util.List;

import com.jsp.hibernate_curd_dto_service_controller.dao.CollegeDao;
import com.jsp.hibernate_curd_dto_service_controller.dto.College;

public class CollegeService {

	CollegeDao collegeDao = new CollegeDao();
	public void saveCollege(College college) {
		collegeDao.saveCollege(college);
	}
	public College getById(int id) {
		return collegeDao.getById(id);
	}
	public void deleteCollege(int id) {
		if(collegeDao.getById(id).getCollegeId()==id) {
		collegeDao.deleteCollege(id);
		System.out.println("data is deleted");
		}
		else {
			System.out.println("Id is not present");
		}
	}
	public void updateCollege(int collegeId,String collegeName, String collegeAdress ) {
		if(collegeDao.getById(collegeId).getCollegeId()==collegeId) {
			collegeDao.updateCollege(collegeId, collegeName, collegeAdress);
			System.out.println("data is Update");
			}
			else {
				System.out.println("Id is not present");
			}
	}
	public void updateCollege(int collegeId,String collegeName) {
		if(collegeDao.getById(collegeId).getCollegeId()==collegeId) {
			collegeDao.updateCollege(collegeId, collegeName);
			System.out.println("data is Update");
			}
			else {
				System.out.println("Id is not present");
			}
	}
	public void updateCollegeAdress(int collegeId,String collegeAdress) {
		if(collegeDao.getById(collegeId).getCollegeId()==collegeId) {
			collegeDao.updateCollegeAdress(collegeId, collegeAdress);
			System.out.println("data is Update");
			}
			else {
				System.out.println("Id is not present");
			}
	}
	public void updateCollegeType(int collegeId,String collegeType) {
		if(collegeDao.getById(collegeId).getCollegeId()==collegeId) {
			collegeDao.updateCollegeType(collegeId, collegeType);
			System.out.println("data is Update");
			}
			else {
				System.out.println("Id is not present");
			}
	}
	public List<College> displayCollege() {
		return collegeDao.displayCollege();
	}
}
