package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Student;
import com.project.dao.StudentDao;

@Controller
public class StudentController 
{
	@Autowired
	StudentDao dao;
	
	@RequestMapping("fillform")
	public ModelAndView fillForm(ModelAndView mv)
	{
		System.out.println("Into fillForm");
		mv.setViewName("fillform");
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("name") String name, @RequestParam("city") String city)
	{
		Student st = new Student();
		
		st.setName(name);
		st.setCity(city);
		dao.save(st);
		System.out.println(st.getName());
		
		return new ModelAndView("redirect:/view");
	}
	
	@RequestMapping("view")
	public ModelAndView showData(ModelAndView mv)
	{
		System.out.println("Into showData");
		
		List<Student> list = dao.getStudents();
		
		/* for(Student model : list) 
		 {
			 System.out.println(model.getName());
			 System.out.println(model.getRollNumber());
			 System.out.println(model.getCity());
		 }*/
		
		mv.addObject("students", list);
		mv.setViewName("showdata");
		return mv;
	}
	
	@RequestMapping(value="/edit/{rollNumber}", method=RequestMethod.POST)
	public ModelAndView editData(@PathVariable int rollNumber, ModelAndView mv)
	{
		Student std;
		try 
		{
			std = dao.editStudentRecord(rollNumber);
			mv.addObject("command", std);
			mv.setViewName("editform");
		} 
		
		catch (Exception e) 
		{
			mv.setViewName("ExceptionHandlingFile");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public ModelAndView saveEdit(@ModelAttribute("std") Student std)
	{
		System.out.println("in saveEdit");
		dao.update(std);
		
		return new ModelAndView("redirect:/view");
	}
	
	@RequestMapping(value="/delete/{rollNumber}", method = RequestMethod.POST)
	public ModelAndView deleteRecord(@PathVariable int rollNumber)
	{
		dao.delete(rollNumber);
		return new ModelAndView("redirect:/view");
	}
	
}
