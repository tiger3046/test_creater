package jp.co.sss.training.lesson01_05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.sss.training.Form.Form;

@Controller
public class FormContoroller {

	@GetMapping(path="/lesson01_05/getForm")
	public String getForm() {
		return "lesson01_05/form";
	}
	
	@GetMapping(path="/doGetForm")
	public String doGetForm(Form form) {
		System.out.println("ユーザーID:" + form.getUserId());
		return "lesson01_05/form";
	}
}
