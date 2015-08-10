package com.bluemaple.angularjs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bluemaple.angular.ServiceImp;
import com.bluemaple.angular.Services;
import com.bluemaple.js.Loginpage;



@Controller
@RequestMapping (value="/user")
public class HomeController {
	@Autowired
	private ServiceImp services;

	
	public ServiceImp getServices() {
		return services;
	}

	public void setServices(ServiceImp services) {
		this.services = services;
	}

	@RequestMapping (value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("username") String username,@RequestParam("password") String password)
	{
		System.out.println("hai");
	Loginpage loginpage=services.getLogin(username,password);
	System.out.println("Loginpage result:"+loginpage);
		return null;
	}
	
	@RequestMapping (value="/signup", method=RequestMethod.POST)
	public String reg(@ModelAttribute Loginpage loginpage)
	{
		System.out.println("hi");
	loginpage=services.getReg(loginpage);	
	return "Register";	
	}
	
}


