package jp.co.sss.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SessionController {
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String doLogin( String userId ) {
		System.out.println("ユーザID:" + userId);
		return "session/login";
	}
}
