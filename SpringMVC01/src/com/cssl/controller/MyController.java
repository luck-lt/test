package com.cssl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ¿ØÖÆÆ÷
 * 
 * @author LT
 *
 */
public class MyController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("MyController handleRequest...");
		ModelAndView mav = new ModelAndView("success");
		mav.addObject("user", "admin");
		return mav;
	}

}
