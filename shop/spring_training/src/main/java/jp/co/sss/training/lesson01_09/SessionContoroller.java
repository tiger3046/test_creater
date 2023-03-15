package jp.co.sss.training.lesson01_09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.training.Form.Form;

@Controller
public class SessionContoroller {
	@GetMapping(path="/lesson01_09/login")
	public String login() {
		return "lesson01_09/login";
	}
	
	@PostMapping(path="/doSessionLogin")
	public String doSessionLogin(Form form,HttpSession session) {
		String userId = form.getUserId();
		if(userId.isEmpty() || userId == null) {
			return"lesson01_09/login";
		}else if(userId.equals(form.getPassword())){
			session.setAttribute("userId", userId);
			return "lesson01_09/user";
		}else {
			return "lesson01_09/login";
		}
	}

}
