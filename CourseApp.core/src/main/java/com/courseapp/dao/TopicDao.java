package com.courseapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.courseapp.service.types.Topic;

public interface TopicDao extends CrudRepository<Topic, String>{

	public Topic findTopicByName(String name);
}
