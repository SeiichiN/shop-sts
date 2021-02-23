package jp.co.sss.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.entity.Item;
import jp.co.sss.shop.form.ItemForm;
import jp.co.sss.shop.repository.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	ItemRepository repository;
	
	@RequestMapping("/items/findAll")
	public String showItemList( Model model ) {
		model.addAttribute("items", repository.findAll());
		return "items/item_list";
	}
	
	@RequestMapping("/items/getOne/{id}")
	public String showItem( @PathVariable int id, Model model ) {
		model.addAttribute("item", repository.getOne(id));
		return "items/item";
	}
	
	@RequestMapping("/items/findByPrice/{price}")
	public String showItemListByPrice( @PathVariable int price, Model model ) {
		model.addAttribute("items", repository.findByPrice( price ));
		return "items/item_list";
	}
	
	@RequestMapping("/items/findByNameAndPrice/{name}/{price}")
	public String showItemListByNameAndPrice( 
			@PathVariable String name, 
			@PathVariable int price,
			Model model ) {
		model.addAttribute("items", repository.findByNameAndPrice(name, price));
		return "items/item_list";
	}
	
	@RequestMapping ("/items/findByNameLike/{name}")
	public String showItemListByNameLike (@PathVariable String name, Model model) {
		model.addAttribute("items", repository.findByNameLike("%" + name + "%"));
		return "items/item_list";
	}
	
	@RequestMapping ("/items/create/input")
	public String createInput () {
		return "items/create_input";
	}
	
	@RequestMapping (path = "/items/create/complete", method = RequestMethod.POST)
	public String createComplete (ItemForm form) {
		Item item = new Item();
		item.setName (form.getName());
		item.setPrice(form.getPrice());
		repository.save(item);
		
		System.out.println(">>>>> item.getId: " + item.getId());
		return "redirect:/items/getOne/" + item.getId();
	}
}
