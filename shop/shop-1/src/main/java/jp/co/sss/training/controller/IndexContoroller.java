package jp.co.sss.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexContoroller {
	
	@RequestMapping(path="/")
	public String index() {
		return "index";
	}
	
}
