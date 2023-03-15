package jp.co.sss.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.training.Form.ItemForm;
import jp.co.sss.training.entity.Item;
import jp.co.sss.training.repository.ItemRepository;

@Controller
public class ItemContoroller {
	@Autowired
	ItemRepository repository;
	
	@GetMapping(path="/items/findAll")
	public String showItemList(Model model) {
		 model.addAttribute("items", repository.findAll());
	     return "items/item_list";
	}
	
	@RequestMapping(path="item/findAllByOrderByPriceDesc")
	public String showFindAllByOrderByDesc(Model model) {
		model.addAttribute("items",repository.findAllByOrderByPriceDesc());
		return"items/item_list";
	}
	
	@RequestMapping(path="/items/getById/{id}")
	public String showItem(@PathVariable int id, Model model) {
		System.out.println(repository.findById(id).getName());
	    model.addAttribute("item", repository.findById(id));
	    return "items/item";
	}
	
	@RequestMapping(path="/items/findByPrice/{price}")
	public String showItemListByPrice(@PathVariable int price, Model model) {
	    model.addAttribute("items", repository.findByPrice(price));
	    return "items/item_list";
	}

	@RequestMapping(path="/items/findByNameAndPrice/{name}/{price}")
	public String showFindByNameAndPrice(Model model,@PathVariable String name,@PathVariable int price) {
		model.addAttribute("items",repository.findByNameAndPrice(name, price));
		return "items/item_list";
	}
	
	@RequestMapping(path="/items/findByNameLike/{name}")
	public String showFindByNameLike(Model model,@PathVariable String name) {
		model.addAttribute("items",repository.findByNameLike("%"+name+"%"));
		return "items/item_list";
	}
	
	@Autowired
	HttpSession session;
	@RequestMapping(path="/items/findAllAndSetDropdown")
	public String itemListSetAnddropdown() {
		session.setAttribute("items",repository.findAll());
		return "items/item_list_dropdown";
	}
	
	@GetMapping(path="/items/create/input")
	public String createInput() {
		return "items/create_input";
	}
	
	@PostMapping(path="/items/create/complete")
	public String createComplete(ItemForm form) {
		Item item = new Item();
		item.setId(form.getId());
		item.setName(form.getName());
		item.setPrice(form.getPrice());
		repository.save(item);
		return "redirect:/items/getById/" + item.getId();
	}
	
	@GetMapping(path="/items/update/input/{id}")
	public String updateInput(Model model,@PathVariable int id) {
		model.addAttribute("item",repository.findById(id));
		Item item = (Item) repository.findById(id);
		System.out.println(item.getId());
		System.out.println(item.getName());
		System.out.println(item.getPrice());
		return "items/update_input";
	}
	
	@PostMapping(path="/items/complete/{id}")
	public String updateComplete(@PathVariable int id,ItemForm form) {
		Item item = repository.findById(id);
		item.setId(form.getId());
		item.setName(form.getName());
		item.setPrice(form.getPrice());
		repository.save(item);
		return "redirect:/items/getById/" + item.getId();
	}
	
	@GetMapping(path="/items/delete/input")
	public String deleteInput() {
		return "items/delete_input";
	}
	
	@PostMapping(path="/items/delete/complete")
	public String deleteComplete(ItemForm form) {
		repository.deleteById(form.getId());
		return "redirect:/items/findAll";
	} 
	
}