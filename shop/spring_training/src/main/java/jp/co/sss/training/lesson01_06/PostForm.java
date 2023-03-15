package jp.co.sss.training.lesson01_06;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.training.Form.Form;

@Controller
public class PostForm {
	@GetMapping(path="/lesson01_06/postForm")
	public String postForm() {
		return "lesson01_06/postForm";
	}
	
	@PostMapping(path="/doPostForm")
	public String doPostForm(Form form) {
		System.out.println("userId:" + form.getUserId());
		return "lesson01_06/postForm";
	}
}
