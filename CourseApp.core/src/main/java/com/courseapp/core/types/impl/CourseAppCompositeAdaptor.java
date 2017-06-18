package com.courseapp.core.types.impl;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.courseapp.core.types.IAdaptor;
import com.courseapp.exception.types.BusinessException;
import com.courseapp.exception.types.SystemException;
import com.courseapp.service.TopicService;
import com.courseapp.service.types.CourseAppHttpRequestType;
import com.courseapp.service.types.CourseAppHttpResponseType;
import com.courseapp.service.types.Topic;

@Component
public class CourseAppCompositeAdaptor implements IAdaptor<CourseAppHttpRequestType,CourseAppHttpResponseType>{

	@Autowired
	private TopicService topicService;
	
	@Override
	public CourseAppHttpResponseType execute(CourseAppHttpRequestType request,String operation) throws BusinessException,SystemException{
		CourseAppHttpResponseType response = new CourseAppHttpResponseType();
		if(operation.equalsIgnoreCase("getAllTopics"))
			response.setTopics(topicService.getAllTopics());
		else if(operation.equalsIgnoreCase("getTopic")){
			response.setTopics(new ArrayList<Topic>(Arrays.asList((topicService.getTopic("Java")))));
		} else if(operation.equalsIgnoreCase("addTopic")){
			response.setTopics(new ArrayList<Topic>(Arrays.asList((topicService.addTopic(request.getTopics().get(0))))));
		}
			
		return response;
	}
}
