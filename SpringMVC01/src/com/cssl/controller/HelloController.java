package com.cssl.controller;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.descriptor.web.LoginConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.cssl.vo.UsersVo;

//@RequestMapping("/admin")  //地址前要加admin
@SessionAttributes(names = "usersVo", types = UsersVo.class)
@Controller
public class HelloController {
	// @RequestMapping(value="/hello",method = RequestMethod.GET) //对应该方式的提交方式，需匹配
	@RequestMapping("/hello")
	public ModelAndView hellor(// @RequestParam防止url传入值为空，defaultValue恒定为0
			@CookieValue(name = "JSESSIONID") String sessionId, @RequestParam(name = "sid", defaultValue = "0") int id,
			String user, ModelAndView mav) {
		System.out.println("hellor...." + id + "\tsessionid:" + sessionId);
		mav.addObject("user", user);
		mav.setViewName("success");
		return mav;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.POST)
	//@RequestMapping("/login")
	@PostMapping("/login")
	public String login(UsersVo uvo, HttpSession session) {
		System.out.println("login:" + uvo.getUsername());
		if (uvo.getUsername().equals("admin")) {
			// session.setAttribute("usersVo", uvo);
			// 重定向
			return "redirect:success.jsp";
		}
		return "index";
	}

	/**
	 * 返回model(对象、集合)的时候，自动将url作为视图名
	 * 
	 * @param LT
	 * @return
	 */
	@PostMapping("/success")
	public UsersVo success(UsersVo uvo) {
		System.out.println("success:" + uvo.getUsername());
		uvo.setUsername("管理员");
		return uvo;
	}
}
