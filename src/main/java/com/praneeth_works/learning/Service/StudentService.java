package com.praneeth_works.learning.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praneeth_works.learning.Entity.Student;
import com.praneeth_works.learning.Repository.StudentRepo;
import java.util.*;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;
	
	public Student saveDetails(Student student) {
		return studentRepo.save(student);
		
	}
	
	public List<Student> getDetails()
	{
		return studentRepo.findAll();
	}
	
	public Student getDetilsById(int id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public String deleteById(int id) {
		if(studentRepo.existsById(id)){
			studentRepo.deleteById(id);
			return "Deleted";
		}else {
			return "Invalid";
		}
	}
	
	public List<Student> saveList(List<Student> list)
	{
		return studentRepo.saveAll(list);
		//return studentRepo.findAll();
	}
	
	public String getMAX()
	{
		return ""+studentRepo.getMaxStudent();
	}
	
	
	//Custom Query
	public List<Student> fitchAllDataCustom()
	{
		return studentRepo.fitchAllDataCustom();
	}
	
	public Student fitchMAXStudentCustom() {
		return studentRepo.fitchAllDataCustom().get(0);
	}
	
	public Student fitchDataUsingName(String name) {
		return studentRepo.fitchDataUsingName(name).get(0);
	}
	
	public Student fitchDataUsingID(int id) {
		return studentRepo.fitchDataUsingID(id);
	}
	
	public List<Student> fitchDataByLimit(int limit){
		return studentRepo.fitchDataByLimit();
	}
}
