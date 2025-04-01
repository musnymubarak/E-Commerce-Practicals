package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Model.StudentModel;

@RestController
@RequestMapping("/app")
public class StudentController {
	StudentModel s1= new StudentModel("2020ICT110", "Musny", 24, "IT", 2.5);
	StudentModel s2= new StudentModel("2020ICT112", "Kumar", 24, "IT", 3.5);
	StudentModel s3= new StudentModel("2020ICT114", "Mala", 23, "IT", 2.9);
	
	List<StudentModel> students= new ArrayList<StudentModel>();
	
	public StudentController() {
		students.add(s1);
		students.add(s2);
		students.add(s3);
	}
	
	@GetMapping("/msg")
	public String myMessage() {
		return "Hello Springboot";
	}
	
	@GetMapping("/name")
	public String myName() {
		return "My Name is  Springboot";
	}
	
	@GetMapping("/age/{ag}")
	public String MyAge(@PathVariable("ag") int age) {
		return "My Age is " +age;
	}
	
	//A method to return a student
	@GetMapping("/student")
	public StudentModel getStudent() {
		return s1;
	}
	
	
	@GetMapping("students")
	public List<StudentModel> getStudents(){
		return students;
	}
	
	@GetMapping("/students/{reg}")
	public StudentModel GetStudentbyRegNo(@PathVariable("reg") String regNo) {
		for(StudentModel student:students) {
			if(student.getRegNo().equals(regNo)) {
				return student;
			}
		}
		return null;
		
	}

	@GetMapping("/students/age-between")
	public List<StudentModel> getStudentsByAgeRange(
	        @RequestParam int minAge, 
	        @RequestParam int maxAge) {
	    return students.stream()
	            .filter(student -> student.getAge() >= minAge && student.getAge() <= maxAge)
	            .collect(Collectors.toList());
	}
	

	
	//Create - Add a new student
	@PostMapping("/students")
	public StudentModel addStudent(@RequestBody StudentModel student) {
		students.add(student);
		return student;
	}
	
	//Update
	
	 @PutMapping("/students/{id}")
	    public StudentModel updateStudent(@PathVariable("id") String regno, @RequestBody StudentModel updatedStudent) {
	        for (int i = 0; i < students.size(); i++) {
	            StudentModel student = students.get(i);
	            if (student.getRegNo().equals(regno)) {
	 
	                student.setName(updatedStudent.getName());
	                student.setAge(updatedStudent.getAge());
	                student.setCourse(updatedStudent.getCourse());
	                student.setGpa(updatedStudent.getGpa());
	                return student;
	            }
	        }
	        return null; 
	    }
	
	//Delete
	 
	 @DeleteMapping("/students/{id}")
	    public boolean deleteStudent(@PathVariable("id") String regno) {
	        return students.removeIf(student -> student.getRegNo().equals(regno));
	    }

}
