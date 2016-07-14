package com.prapps.tutorial.spring.neo4j.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prapps.tutorial.spring.neo4j.persistence.Train;
import com.prapps.tutorial.spring.neo4j.repo.TrainRepository;

@Controller
@RequestMapping("/rail")
@Transactional
public class RailwayController {

	@Autowired TrainRepository trainRepository;
	
	@RequestMapping("/{id}")
	public @ResponseBody Train findTrain(@PathVariable(value = "id") Long id) {
		return trainRepository.findOne(id);
	}
	
	@Transactional
	@RequestMapping("/create")
	public @ResponseBody Train create(@PathParam("id") Long id, @PathParam("name") String name) {
		Train t = new Train();
		t.setId(id);
		t.setName(name);
		return trainRepository.save(t);
	}
	
	@RequestMapping("/all")
	public @ResponseBody Iterable<Train> findAll() {
		return trainRepository.findAll();
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String test() {
		return "hello";
	}
}