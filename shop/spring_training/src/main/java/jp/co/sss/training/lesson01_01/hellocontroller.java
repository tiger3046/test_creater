package jp.co.sss.training.lesson01_01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hellocontroller {
	@RequestMapping(path="lesson01_01/hello")
	public String hello() {
		return "lesson01_01/hello";
	}

}
