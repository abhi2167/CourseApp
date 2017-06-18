package com.courseapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.service.CourseService;
import com.courseapp.service.types.Course;

@RestController
public class CourseController  {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.GET)
	public List<Course> getAllCoursesByTopicId(@PathVariable String topicId){
		return courseService.getAllCoursesByTopicId(topicId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.GET)
	public Course getCourse(@PathVariable String topicId, @PathVariable String courseId){
		return courseService.getCourse(topicId, courseId);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses", method=RequestMethod.POST)
	public Course addCourseByTopicId(@PathVariable String topicId, @RequestBody Course course){	
		System.out.println("POST method by TopicId************");
		return courseService.addCourseByTopicId(topicId, course);	
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.PUT)
	public Course updateCourse(@PathVariable String topicId, @PathVariable String courseId, @RequestBody Course course){
		System.out.println("Entering PUt Method**********");
		return courseService.updateCourse(topicId, courseId, course);
	}
	
	@RequestMapping(value="/topics/{topicId}/courses/{courseId}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String topicId, @PathVariable String courseId){
		System.out.println("**********Deleting Course by ID  ***********");
		courseService.deleteCourse(topicId, courseId);
	}
}