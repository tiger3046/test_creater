package jp.co.sss.training.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.training.Form.Form;
import jp.co.sss.training.Form.TrainingUserForm;
import jp.co.sss.training.entity.TrainingUser;
import jp.co.sss.training.repository.UserRepository;

@Controller
public class LoginContorollerByDB {
	@Autowired
	UserRepository repository;
	@GetMapping(path="/lesson02_01/login")
	public String login() {
		return "/lesson02_01/login";
	}
	
	@Autowired
	HttpSession session;
	
	@PostMapping(path="/lesson02_01/doLogin")
	public String doLogin(Form form) {
		String userid = form.getUserId();
		String password = form.getPassword();
		TrainingUser user = repository.findByUserIdAndPassword(userid, password); 
		if(user != null) {
			System.out.println(user);
			session.setAttribute("user", user);
			return "/lesson02_01/user_loggedin";
		}else {
			System.out.println("This userId or password or both is not permited.");
			return "/lesson02_01/login";
		}
	}
	
	@GetMapping(path="/leson02_02/create/input")
	public String createInput() {
		return "/lesson02_02/create_input";
	}
	
	@PostMapping(path="/lesson02_02/create/complete")
	public String createComplete(TrainingUserForm form) {
		TrainingUser user = new TrainingUser();
		user.setId(form.getId());
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		repository.save(user);
		return"/lesson02_02/user_data";
	}
	
	@PostMapping(path="/lesson02_02/create/update")
	public String updateInput(TrainingUserForm form) {
		TrainingUser user = repository.findById(form.getId());
		user.setId(form.getId());
		user.setUserId(form.getUserId());
		user.setPassword(form.getPassword());
		repository.save(user);
		return "/lesson02_02/create_update";
	}
}