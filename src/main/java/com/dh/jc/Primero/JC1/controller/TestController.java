package com.dh.jc.Primero.JC1.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dh.jc.Primero.JC1.model.Person;

@RestController
public class TestController {
	
	@RequestMapping(value = "hello-spring", method = RequestMethod.GET)
	public String helloSpring() 
	{
		return "Hola Mundo uno";
	}
	
	@GetMapping("hello-spring-version-2")
	public String helloSpringV2()
	{
		return "Hola Dossss";
	}
	
	@GetMapping("person")
	public Person obtenerPersonaDeLaBaseDeDatos()
	{
		Date birth = new Date();
		Person person = new Person("JC", "GL", birth);
		return person;
	}
	
}
