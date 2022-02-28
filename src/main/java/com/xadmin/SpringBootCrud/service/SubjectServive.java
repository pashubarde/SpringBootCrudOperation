package com.xadmin.SpringBootCrud.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xadmin.SpringBootCrud.repository.SubjectRepository;
import com.xadmin.SpringBootCrud.rest.model.Subject;

@Service
public class SubjectServive {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<Subject> getAllSubjects() {
		List<Subject> allSubjects = new ArrayList<>();
		subjectRepository.findAll().forEach(allSubjects::add);
		return allSubjects;
		
	}

	public void addSubject(Subject subject) {
		subjectRepository.save(subject);
	}

	public Subject getSubject(Integer id) {
		Subject subject = subjectRepository.findById(id).get();
		return subject;
	}

	public void updateSubject(String id, Subject subject) {
		subjectRepository.save(subject);		
	}

	public String deleteSubject(Integer id) {
		subjectRepository.deleteById(id);
		return "Subject Deleted Successfully...!!!!";
	}

}
