package jp.co.sss.shop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.form.LoginForm;

@Controller
public class SessionController {
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String doLogin( LoginForm form, HttpSession session ) {
		if (form.getUserId() == 123) {
			// 入力したユーザIDをスコープ変数 userId に代入し、
			// その変数をセッションに登録
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/login";
		}		
	}
	
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout( HttpSession session ) {
		// セッションの破棄
		session.invalidate();
		return "redirect:/";
		
	}
}
