package com.courseapp.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.courseapp.core.types.IAdaptor;
import com.courseapp.exception.types.BusinessException;
import com.courseapp.exception.types.CourseAppServiceException;
import com.courseapp.service.TopicService;
import com.courseapp.service.types.CourseAppHttpRequestType;
import com.courseapp.service.types.CourseAppHttpResponseType;
import com.courseapp.service.types.Topic;

@RestController
@ManagedResource(objectName = "courseApp:name=topicController")
public class TopicController extends AbstractServiceController {

	@Autowired
	private TopicService topicService;
	
	@Value("${app.welcomeMessage:Welcome to CourseApp !!! - default}")
	private String welcomeMessage;
	
	private String defaultMessage = "Welcome to CourseApp !!!";
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TopicController.class);
	
	@Autowired
	private IAdaptor<CourseAppHttpRequestType,CourseAppHttpResponseType> courseAppAdaptor;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String loadHome() {
		String message = "";
		System.out.println(" Welcome Message is: "+welcomeMessage);
		if(StringUtils.isEmpty(welcomeMessage)){
			message = defaultMessage;
		} else {
			message = welcomeMessage;
		}
		return message;
	}
	@RequestMapping(value ="/topics", method=RequestMethod.GET)
	public ResponseEntity<CourseAppHttpResponseType> getAllTopics(CourseAppHttpRequestType request) throws CourseAppServiceException {
		setMDC(UUID.randomUUID().toString());
		logger.debug("Execute start");
		CourseAppHttpResponseType response = null;
		try {
			response = courseAppAdaptor.execute(request, "getAllTopics");
		} catch(BusinessException e){
			handleBusinessException(response,e);
		} catch(Exception e){
			handleUnknownException(response,e);
		}finally {
			logger.debug("Execute end");
			resetMDC();
		}
		return new ResponseEntity<CourseAppHttpResponseType>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value="/topics/{name}", method=RequestMethod.GET)
	public ResponseEntity<CourseAppHttpResponseType> getTopic(@PathVariable String name,CourseAppHttpRequestType request) throws CourseAppServiceException{
		setMDC(UUID.randomUUID().toString());
		logger.debug("Execute start");
		CourseAppHttpResponseType response = null;
		try{
			response = courseAppAdaptor.execute(request, "getTopic");
		} catch(BusinessException e){
			handleBusinessException(response,e);
		} catch(Exception e){
			handleUnknownException(response,e);
		} finally {
			logger.debug("Execute end");
			resetMDC();
		}
		return new ResponseEntity<CourseAppHttpResponseType>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value="/topics", method=RequestMethod.POST)
	public ResponseEntity<CourseAppHttpResponseType> addTopic(@RequestBody CourseAppHttpRequestType request) throws CourseAppServiceException {
		setMDC(UUID.randomUUID().toString());
		logger.debug("Execute start");
		CourseAppHttpResponseType response = null;
		try{
			response = courseAppAdaptor.execute(request, "addTopic");
		} catch(BusinessException e){
			handleBusinessException(response,e);
		} catch(Exception e){
			handleUnknownException(response,e);
		} finally {
			logger.debug("Execute end");
			resetMDC();
		}
		return new ResponseEntity<CourseAppHttpResponseType>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
		topicService.updateTopic(topic, id);
	}
	
	@RequestMapping(value="/topics/{id}", method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id){
		topicService.deleteTopic(id);
	}
	
	@ManagedAttribute
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	@ManagedAttribute
	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}
	
	
}
