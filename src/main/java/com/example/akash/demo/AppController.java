package com.example.akash.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
	
	@RequestMapping("/")
	public String start() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/doInsert",method = RequestMethod.GET)
	public String insertData(@ModelAttribute("uname1") String name,
						@ModelAttribute("uage1") int age,
						@ModelAttribute("ucity1") String city) throws Exception {
		System.out.println("do insert"); 
		System.out.println(name+" "+age+" "+city);
		new HibernateUtil().insert(name, age, city);
		return "index.jsp";
		
	}
	
	@RequestMapping(value="/doUpdate",method = RequestMethod.GET)
	public String updateData(@ModelAttribute("uid2") int id, @ModelAttribute("uname2") String name,
					@ModelAttribute("uage2") int age, @ModelAttribute("ucity2") String city) throws Exception {
		System.out.println("do update"); 
		System.out.println(id+" "+name+" "+age+" "+city); 
		new HibernateUtil().update(id, name, age, city);
		return "index.jsp";
		
	}
	
	@RequestMapping(value="/doDelete",method = RequestMethod.GET)
	public String deleteData(@ModelAttribute("uid3") int id) throws Exception {
		System.out.println("do delete"); 
		System.out.println(id);
		new HibernateUtil().delete(id);
		return "index.jsp";
		
	}

}
