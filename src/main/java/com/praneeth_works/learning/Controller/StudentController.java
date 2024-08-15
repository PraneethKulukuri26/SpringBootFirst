package com.praneeth_works.learning.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.praneeth_works.learning.Entity.Student;
import com.praneeth_works.learning.Service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	

	@Autowired
	JavaMailSender mailSender;
	
	@PostMapping("/addStudent")
	public Student postDetails(@RequestBody Student student) {
		return studentService.saveDetails(student);
	}
	
	@GetMapping("/getStudents")
	public List<Student> getDetails(){
		return studentService.getDetails();
	}
	
	@GetMapping("/getDataById/{id}")//  http://localhost:8080/getDataById/3
	public Student getByid(@PathVariable("id") int id) {
		return studentService.getDetilsById((int)id);
	}
	
	@DeleteMapping("/deleteById/{id}") //  http://localhost:8080/deleteById/1
	public String deleteById(@PathVariable("id") int id) {
		return studentService.deleteById(id);
	}
	
	@PostMapping("/addList") // http://localhost:8080/addList
	public List<Student> saveList(@RequestBody List<Student> list)
	{
		return studentService.saveList(list);
	}
	
	@GetMapping("/getMAX")
	public String getMAX() {
		return studentService.getMAX();
	}
	
	//custom Query
	@GetMapping("/custom/fitchAllData")
	public List<Student> getAllData()
	{
		return studentService.fitchAllDataCustom();
	}
	
	@GetMapping("/custom/fitchMAXStudent")
	public Student getMAXStudent() {
		return studentService.fitchMAXStudentCustom();
	}
	
	@GetMapping("/custom/fitchDataName/{name}")
	public Student getDataByName(@PathVariable("name") String name) {
		return studentService.fitchDataUsingName(name);
	}
	
	@GetMapping("/custom/fitchDataByID/{id}")
	public Student getDataByID(@PathVariable("id") int id) {
		return studentService.fitchDataUsingID(id);
	}
	
	@GetMapping("/custom/fitchDataByLimit/{li}")
	public List<Student> getDataByLimit(@PathVariable("li") int li){
		return studentService.fitchDataByLimit(li);
	}
	
	@GetMapping("/just")//  http://localhost:8080/just?code=1&Message=Hello
	public String getSomeThing(@RequestParam("code") int code,@RequestParam("Message") String message) {
		return "code:"+code+"\nMessage:"+message;
	}
	
	@GetMapping("/email")
	public String sendMail(@RequestParam("email") String email) {
		try
		{
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom("praneethscienceprojectscodes@gmail.com");
			mailMessage.setTo(email);
			mailMessage.setSubject("sent using java");
			mailMessage.setText("This is the first email using java");
			
			mailSender.send(mailMessage);
			return "Email sent successfully";
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
	
}
	
