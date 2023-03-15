package jp.co.sss.training.lesson01_07;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Login {
	
	@GetMapping(path="/lesson01_07/login")
	public String login() {
		return "lesson01_07/login";
	}
	
	//空文字なしなので最初に空文字判定がくる。
	@PostMapping(path="/doLogin")
	public String doLogin(String userId,String password) {
		if(userId == null || userId.isEmpty()) {
			return "lesson01_07/login";
		}else if(userId.equals(password)) {
			return "lesson01_07/success";
		}else {
			System.out.println(userId + password);
			System.out.println(userId.equals(password));	
			return "lesson01_07/login";
		}
	}
}
