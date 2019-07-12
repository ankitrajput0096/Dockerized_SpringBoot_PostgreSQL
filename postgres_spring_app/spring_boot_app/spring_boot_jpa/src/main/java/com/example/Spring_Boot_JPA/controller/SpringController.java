package com.example.Spring_Boot_JPA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spring_Boot_JPA.model.Topic;
import com.example.Spring_Boot_JPA.service.springBootService;

@RestController
@RequestMapping(value="/springBootJpa")
public class SpringController {
	
	@Autowired
	private springBootService springbootservice;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String helloMethod()
	{
		return "hello friends";
	}
	
	@RequestMapping(value="/topics")
	public List<Topic> listOfTopcs()
	{
		return springbootservice.getAllTopics();
	}
	
	@RequestMapping(value="/topics/{id}")
	public Topic getRequiredTopic(@PathVariable String id)
	{
		return springbootservice.getTopic(id);
	}
	
	
	//In this json object is sent 
	/*
	 * {
	 * 		"id":"java"
	 * 		"name":"java programming"
	 * 		"description":"java is easy"
	 * }
	 */
	@RequestMapping(value="/topics/add",method=RequestMethod.POST)
	public void addTopic(@RequestBody Topic topic)
	{
		springbootservice.addTopic(topic);
	}
	
	@RequestMapping(value="/topics/update/{id}",method=RequestMethod.PUT)
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		springbootservice.updatetopic(topic,id);
	}
	
	
	//Url "localhost:8080/springBootJpa/topics/delete/java
	@RequestMapping(value="/topics/delete/{id}",method=RequestMethod.DELETE)
	public void deleteTopic(@PathVariable String id)
	{
		springbootservice.deletetopic(id);
	}
	
	
	//Url "localhost:8080/springBootJpa/topics/getById?id=java
	@RequestMapping(value="/topics/getById",method=RequestMethod.GET)
	public Topic getById(@RequestParam(value="id")String id)
	{
		return springbootservice.getById(id);
	}
	
	
	@RequestMapping(value="/topics/getByIdAndName",method=RequestMethod.GET)
	public Topic getByIdAndName(@RequestParam(value="id")String id,@RequestParam(value="name")String name)
	{
		return springbootservice.getByIdAndName(id, name);
	}
	
}
