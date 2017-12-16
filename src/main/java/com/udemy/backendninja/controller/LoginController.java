package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.udemy.backendninja.constant.ViewConstant;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	 public String showLoginForm(@RequestParam(name="error", required = false ) String error, 
			 Model model, @RequestParam(name="logout", required = false) String logout) {
		LOG.info("Call: Method showLoginForm() -- PARAM: Error: "+error + " Logout: "+logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		 return ViewConstant.LOGIN;
	 }
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		LOG.info("Call: Method loginCheck()'  ");
		LOG.info("Entro como: "+ SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			LOG.info("Returning to contact view");
			return "redirect:/contacts/showcontacts";
	}

}
