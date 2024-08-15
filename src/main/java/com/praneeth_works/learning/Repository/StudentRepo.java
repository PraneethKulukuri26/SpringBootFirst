package com.praneeth_works.learning.Repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.praneeth_works.learning.Entity.Student;
import java.util.*;

public interface StudentRepo extends JpaRepository<Student,Integer> {
	
	@Query(value="SELECT MAX(mark) FROM Student")
	public int getMaxStudent();
	
	//custom Query
	
	@Query(value="SELECT s FROM  Student s")
	public List<Student> fitchAllDataCustom();
	
	@Query(value="SELECT s FROM Student s WHERE mark=(SELECT MAX(mark) FROM Student)")
	public List<Student> getMaxStudentDetailsCustom();
	
	@Query(value="SELECT s FROM Student s WHERE name=:val")
	public List<Student> fitchDataUsingName(@Param("val") String name);
	
	@Query(value="SELECT s FROM Student s WHERE id=:id")
	public Student fitchDataUsingID(@Param("id") int id);
	
	@Query(value="SELECT s FROM Student s")
	public List<Student> fitchDataByLimit();
}
