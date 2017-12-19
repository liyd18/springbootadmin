package com.wht.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wht.config.ErrorCode;
import com.wht.config.User;

@Controller
@RequestMapping
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private User user;
	
	@RequestMapping("login")
	public String login(){
		log.info("--------跳转登录页面--------");
		return "login";
	}
	
	@RequestMapping(value="enter",method = RequestMethod.POST)
	public @ResponseBody String enter(User u, HttpServletRequest request) throws Exception{
		log.info("--------登录验证--------");
		try {
			if (StringUtils.isBlank(u.getUsername())||StringUtils.isBlank(u.getPassword())) {
				return ErrorCode.ACS_10001.toString();
			}
			if (!user.getUsername().equals(u.getUsername())) {
				return ErrorCode.ACS_10008.toString();
			}
			if (!user.getPassword().equals(u.getPassword())) {
				return ErrorCode.ACS_10002.toString();
			}
			request.getSession().setAttribute("user", user);
			request.getSession().setMaxInactiveInterval(60*60);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
