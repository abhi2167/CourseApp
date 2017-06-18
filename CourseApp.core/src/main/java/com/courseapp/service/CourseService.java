package com.courseapp.service;

import java.util.List;

import com.courseapp.core.types.IService;
import com.courseapp.service.types.Course;

public interface CourseService extends IService{

	public List<Course> getAllCoursesByTopicId(String id);
	
	public Course addCourseByTopicId(String topicId, Course course);
	
	public Course updateCourse(String topicId, String courseId, Course course);
	
	public Course getCourse(String topicId, String courseId);
	
	public void deleteCourse(String topicId, String courseId);
}
