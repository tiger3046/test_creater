package jp.co.sss.training.lesson01_02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BeforeController {
	@RequestMapping(path="/lesson01_02/before")
	public String before() {
		return "lesson01_02/before";
	}
}
