package com.courseapp.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.dao.TopicDao;
import com.courseapp.exception.types.BusinessException;
import com.courseapp.service.TopicService;
import com.courseapp.service.types.CourseAppServiceExceptionConstants;
import com.courseapp.service.types.MessageSeverityCode;
import com.courseapp.service.types.SeverityType;
import com.courseapp.service.types.Topic;

@Service
public class TopicServiceImpl implements TopicService{
	
	@Autowired
	private TopicDao topicDao;

	/* Java 8 List to Map Conversion
	private List<Topic> topicList = new ArrayList<Topic>(Arrays.asList(new Topic(UUID.randomUUID().toString(),"java","Core and Advance Java Courses"),
			 new Topic(UUID.randomUUID().toString(),"Dot Net","ASP and Visual Basic Courses"))); 
	
	private Map<String,Topic> topics = topicList.stream().collect(Collectors.toMap(Topic::getId, Function.identity())); */
	
	
	public List<Topic> getAllTopics() throws BusinessException{
		
		//return new ArrayList<Topic>(topics.values());
		List<Topic> topics = new ArrayList<Topic>();
	    topicDao.findAll().forEach(topics::add);
	    if(topics.isEmpty()) {
			throw new BusinessException(MessageSeverityCode.ERROR, SeverityType.BUSINESS, CourseAppServiceExceptionConstants.NO_TOPICS_FOUND.getStatusCode(),
					CourseAppServiceExceptionConstants.NO_TOPICS_FOUND.getDescription(), "CourseApp");
		}
	    
		return topics;
	}

	@Override
	public Topic getTopic(String name) {
		//return topics.values().stream().filter((p) -> p.getName().equalsIgnoreCase(name)).findFirst().get();
		return topicDao.findTopicByName(name);
	}

	@Override
	public Topic addTopic(Topic topic) {
		/* topic.setId(UUID.randomUUID().toString());
		topics.put(topic.getId(), topic);
		return topics.get(topic.getId()); */
		topic.setId(UUID.randomUUID().toString());
		return topicDao.save(topic);
	}
	
	@Override
	public void updateTopic(Topic topic,String id){
		//topics.put(id, topic);
		if(topicDao.exists(id));
			topicDao.save(topic);
	}

	@Override
	public void deleteTopic(String id) {
		//topics.remove(id);
		topicDao.delete(id);
	}
	
}
