package com.jsp.hibernate_curd_dto_service_controller.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.hibernate_curd_dto_service_controller.dto.College;

public class CollegeDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ansari");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	public void saveCollege(College college) {
		entityTransaction.begin();
		entityManager.persist(college);
		entityTransaction.commit();
	}
	public College getById(int id) {
	  College c = entityManager.find(College.class, id);
	  return c;
		
	}
	public void deleteCollege(int id) {
		College c =  entityManager.find(College.class, id);
		entityTransaction.begin();
		entityManager.remove(c);
		entityTransaction.commit();
	}
	public List<College> displayCollege() {
		String display = "SELECT A FROM College A";
	Query query  =	entityManager.createQuery(display);
	List<College> colleges = query.getResultList();
	return colleges;
//		return entityManager.createQuery(display).getResultList();
	  
	}
	public void updateCollege(int collegeId,String collegeName, String collegeAdress ) {
		College college = getById(collegeId);
		if(college!=null) {
			college.setCollegeName(collegeName);
			college.setCollegeAddress(collegeAdress);
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();
		}
	}

	public void updateCollege(int collegeId,String collegeName) {
		College college = getById(collegeId);
		if(college!=null) {
			college.setCollegeName(collegeName);
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();
		}
	}
	public void updateCollegeAdress(int collegeId,String collegeAdress) {
		College college = getById(collegeId);
		if(college!=null) {
			college.setCollegeName(collegeAdress);
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();
		}
	}
	public void updateCollegeType(int collegeId,String collegeType) {
		College college = getById(collegeId);
		if(college!=null) {
			college.setCollegeType(collegeType);
			entityTransaction.begin();
			entityManager.merge(college);
			entityTransaction.commit();
		}
	}
	
}
