package jp.co.sss.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.training.Form.LoginForm;

@Controller
public class SessionController {
	@GetMapping(path="/login")
	public String login() {
		return "session/login";
	}
	
	@GetMapping(path="/doLogin")
	public String doLoginGet(String userId, String password) {
		System.out.println("ユーザーID:" + userId);
		System.out.println("パスワード:" + password);
		return "session/login";
	}
	
	@PostMapping(path="/doLogin")
	public String doLoginPost(String userId) {
		System.out.println("ユーザーID:" + userId);
		return "session/login";
	}
	
	@GetMapping(path="/LoginUsingForm")
	public String loginUsingForm() {
		return "session/loginUsingForm";
	}
	
	@PostMapping(path="/doLoginUsingForm")
	public String doLoginUsingForm(LoginForm form) {
		System.out.println("ユーザーID:" + form.getUserId());
		System.out.println("パスワード：" + form.getPassword());
		return "session/loginUsingForm";
	}
	
	@GetMapping(path="/loginOnRequest")
	public String loginOnRequest() {
		return "session/loginOnRequest";
	} 
	
	@PostMapping(path="/doLoginOnRequest")
	public String doLoginOnRequest(LoginForm form,Model model) {
		model.addAttribute("userId", form.getUserId());
		return "session/loginOnRequest";
	}
	
	@GetMapping(path="/loginOnSession")
	public String loginOnSession() {
		return"session/loginOnSession";
	}
	
	@PostMapping(path="/doLoginOnSession")
	public String doLoginOnSession(LoginForm form,HttpSession session) {
		if(form.getUserId() == 123) {
			//入力したユーザーIDをスコープ変数userIdに代入し、
			//その変数をいセッションに登録
			System.out.println("Login success");
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		}else {
			System.out.println(form.getUserId());
			return "session/loginOnSession";
		}
	}
	
	@GetMapping(path="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
