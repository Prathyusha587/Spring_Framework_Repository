package com.java.springormhibernate.SpringORMHibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.java.springormhibernate.SpringORMHibernate.entities.Student;

public class StudentDao {
    
	//create an object of HibernateTemplate class that interacts with MySQL database 
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int insert(Student student) {
		Integer i = (Integer)this.hibernateTemplate.save(student);
		return i;
	}
	
	//get the single Student record(object)
	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	//get multiple/all data rows- read operation variant 2
	public List<Student>  getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	
	//deleting the data
	@Transactional
	public void deleteStudent(int studentId) {
		
		//to delete a student, we need to get the student first
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}
	
	//update the student data
	@Transactional
	public void updateStudent(int id, String name, String city)
	{
		Student student = this.hibernateTemplate.get(Student.class, id);
		student.setStudentName(name);
		student.setStudentCity(city);
		this.hibernateTemplate.save(student);
	}
	//step2: next, will make a menu driven application to check if all above CRUD operations are working properly
}
