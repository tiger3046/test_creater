package jp.co.sss.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.training.entity.Category;
import jp.co.sss.training.entity.ItemsWithCategories;
import jp.co.sss.training.repository.ItemsWithCategoriesRepository;

@Controller
public class ItemsWithCategoriesController {
	
	@Autowired
	ItemsWithCategoriesRepository repository;
	
	@GetMapping(path="/items/findItemAndCategory")
	public String findItemAndCategory(Model model) {
		model.addAttribute("items",repository.findAll());
		return "items/item_category_list";
	}
	
	@GetMapping(path="/items/serchByCategoryId/{id}")
	public String findByCategoryId(@PathVariable int id,Model model) {
		Category category = new Category();
		category.setId(id);
		List<ItemsWithCategories> items= repository.findByCategory(category);  
		model.addAttribute("items",items);
		return "items/item_category_list";
	}
	
	@Autowired 
	EntityManager entityManeger;
	@GetMapping(path="/items/searchWithNamedQuery/{id}")
	public String serchWithNamedQuery(@PathVariable int id,Model model) {
		Query query = entityManeger.createNamedQuery("findByIdNamedQuery");
		query.setParameter("id",id);
		List<ItemsWithCategories> items =(List<ItemsWithCategories>) query.getResultList();
		model.addAttribute("items",items);
		return "items/item_category_list";
	}
	
	@GetMapping(path="items/searchWithQuery")
	public String serchWithQuery(Model model) {
		model.addAttribute("items",repository.findByPriceGreaterThanEqualAVGPriceQuery());
		return "items/item_category_list";
	}
	
}