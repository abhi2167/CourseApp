package com.courseapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.courseapp.service.types.Course;

public interface CourseDao extends CrudRepository<Course,String> {

	public List<Course> findByTopicId(String id);
	
	
}
