package com.courseapp.service;

import java.util.List;

import com.courseapp.core.types.IService;
import com.courseapp.exception.types.BusinessException;
import com.courseapp.service.types.Topic;

public interface TopicService extends IService {

	public List<Topic> getAllTopics() throws BusinessException;
	
	public Topic getTopic(String name);
	
	public Topic addTopic(Topic topic);
	
	public void updateTopic(Topic topic,String id);
	
	public void deleteTopic(String id);
}
