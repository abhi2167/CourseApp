package com.courseapp.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.dao.CourseDao;
import com.courseapp.dao.TopicDao;
import com.courseapp.service.CourseService;
import com.courseapp.service.types.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	@Autowired
	private TopicDao topicDao;
	
	@Override
	public List<Course> getAllCoursesByTopicId(String id) {
		return courseDao.findByTopicId(id);
	}

	@Override
	public Course addCourseByTopicId(String topicId, Course course) {
		course.setTopic(topicDao.findOne(topicId));
		course.setId(UUID.randomUUID().toString());
		return courseDao.save(course);
	}

	@Override
	public Course updateCourse(String topicId, String courseId, Course course) {
		course.setTopic(topicDao.findOne(topicId));
		return courseDao.save(course);
	}

	@Override
	public Course getCourse(String topicId, String courseId) {
		return courseDao.findOne(courseId);
	}

	@Override
	public void deleteCourse(String topicId, String courseId) {
		courseDao.delete(courseId);
	}
	
}
