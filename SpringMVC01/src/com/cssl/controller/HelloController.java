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

//@RequestMapping("/admin")  //��ַǰҪ��admin
@SessionAttributes(names = "usersVo", types = UsersVo.class)
@Controller
public class HelloController {
	// @RequestMapping(value="/hello",method = RequestMethod.GET) //��Ӧ�÷�ʽ���ύ��ʽ����ƥ��
	@RequestMapping("/hello")
	public ModelAndView hellor(// @RequestParam��ֹurl����ֵΪ�գ�defaultValue�㶨Ϊ0
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
			// �ض���
			return "redirect:success.jsp";
		}
		return "index";
	}

	/**
	 * ����model(���󡢼���)��ʱ���Զ���url��Ϊ��ͼ��
	 * 
	 * @param LT
	 * @return
	 */
	@PostMapping("/success")
	public UsersVo success(UsersVo uvo) {
		System.out.println("success:" + uvo.getUsername());
		uvo.setUsername("����Ա");
		return uvo;
	}
}
