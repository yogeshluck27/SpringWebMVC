package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private AuthenticationService authenticationService;

	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	//http://localhost:8080/login?name=Yogesh
	/*@RequestMapping(value="/login",method = RequestMethod.GET)
	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
		model.put("name", name);
		System.out.println("name is "+name);
		return "login";
	}*/
	
	//http://localhost:8080/login
		@RequestMapping(value="/login",method = RequestMethod.GET)
		public String gotoLoginPage() {
			return "login";
		}
		
	@RequestMapping(value="login",method = RequestMethod.POST)
	//login?name=Ranga RequestParam
	public String gotoWelcomePage(@RequestParam String name, 
			@RequestParam String password, ModelMap model) {
		
		if(authenticationService.authenticate(name, password)) {
		
			model.put("name", name);
			//Authentication 
			//name - in28minutes
			//password - dummy
			
			return "welcome";
		}
		model.put("errorMessage", "Invalid Credentials.Please Try again");
		return "login";
	}
}
