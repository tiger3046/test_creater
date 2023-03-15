package jp.co.sss.training.contoroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.co.sss.training.Form.FoodForm;
import jp.co.sss.training.Form.SerchForm;
import jp.co.sss.training.entity.Food;
import jp.co.sss.training.repository.FoodRepository;

@Controller
public class FoodContoroller {
	@Autowired
	FoodRepository repository;
	
	@GetMapping(path="/lesson03_01/index")
	public String indexResultAll(Model model) {
		model.addAttribute("foods",repository.findAll());
		return "lesson03_01/food_index";
	}
	
	//検索結果をお気に入り登録できるようgetメソッドを採用している。
	@GetMapping(path="/lesson03_01/serch/word/include")
	public String serchWordInclude(Model model,SerchForm form) {
		model.addAttribute("foods",repository.findByKeyword(form.getWord()));
		return"lesson03_01/food_index";
	}
	
	@GetMapping(path="/lesson03_02/create/input")
	public String showCreateInput(Model model) {
		//使用しているRDBMSにidを自動生成機能がある場合は、"itemnumber"は不要。
		//Mysqlは自動生成できないため、次のidをデフォルト入力してある。
		model.addAttribute("itemnumber", repository.countFoodNumber());
		return "lesson03_02/create_input";
	}
	
	@PostMapping(path="/lesson03_02/create/complete")
	public String createComplete(FoodForm form) {
		Food food = new Food();
		food.setId(form.getId());
		food.setName(form.getName());
		food.setStock(form.getStock());
		repository.save(food);
		return"/lesson03_02/create_complete";
	}
	
	@GetMapping(path="/lesson03_02/create/update/{id}")
	public String createUpdate(@PathVariable int id,Model model) {
		model.addAttribute("food",repository.findById(id));
		return "lesson03_02/create_update";
	}
	
	@PostMapping(path="/lesson03_02/update/complete")
	public String updateComplete(FoodForm form) {
		Food food = repository.findById(form.getId());
		food.setId(form.getId());
		food.setName(form.getName());
		food.setStock(form.getStock());
		repository.save(food);
		return "/lesson03_02/create_complete";
	}
	
	@GetMapping(path="/lesson03_02/delete/{id}")
	public String updateComplete(@PathVariable int id) {
		repository.deleteById(id);
		return "redirect:/lesson03_01/index";
	}
}
