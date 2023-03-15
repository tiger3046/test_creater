package jp.co.sss.training.lesson01_08;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.training.Form.Form;

@Controller
public class LoginContoroller {
	@GetMapping(path="/lesson01_08/login")
	public String login() {
		return "lesson01_08/login";
	} 
	
	@PostMapping(path="/doFormLogin")
	public String doLogin(Form form) {
		
		String userId = form.getUserId();
		
		if(userId.isEmpty() || userId == null) {
			return "/lesson01_08/login";
		}else if(userId.equals(form.getPassword())){
			return "/lesson01_07/success";
		}else {
		return "/lesson01_08/login";
		}
	}
}
