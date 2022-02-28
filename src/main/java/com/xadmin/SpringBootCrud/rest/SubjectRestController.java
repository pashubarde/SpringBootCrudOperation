package com.xadmin.SpringBootCrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.xadmin.SpringBootCrud.rest.model.Subject;
import com.xadmin.SpringBootCrud.service.SubjectServive;

@RestController
public class SubjectRestController {

	@Autowired
	private SubjectServive sujectService;
	
	@GetMapping(value = "/getallsubjects",
			produces = {"application/json","application/xml"})
	public List<Subject> getAllSubjects() {
		
		List<Subject> allSubjects = sujectService.getAllSubjects();
		return allSubjects;
	}
	
	@PostMapping(value = "/addsubject",
			consumes = {"application/json","application/xml"})
	public void addSubject(@RequestBody Subject subject){
		sujectService.addSubject(subject);
	}
	
	@GetMapping(value = "/getsubject/{id}",
			produces = {"application/json","application/xml"})
	public Subject getSubject(@PathVariable Integer id) {
		Subject subject = sujectService.getSubject(id);
		return subject;
	}
	
	@PutMapping(value = "/updatesubject/{id}",
			consumes = {"application/json","application/xml"})
	public void updateSubject(@PathVariable String id,@RequestBody Subject subject) {
		sujectService.updateSubject(id, subject);
	}
	
	@DeleteMapping("/deleteSubject/{id}")
	public String deleteSubject(@PathVariable Integer id) {
		String deleteSubject = sujectService.deleteSubject(id);
		return deleteSubject;
	}
}
