package com.example.supplierManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
	@Autowired
	private SupplierService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		
		List<Supplier>listSuppliers =service.listAll();
		model.addAttribute("listSuppliers",listSuppliers);//event handling
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewSupplierFrom(Model model) {
		Supplier supplier = new Supplier();
		model.addAttribute("supplier", supplier);
		
		return "new_supplier";
	}
	
	@RequestMapping(value ="/save", method=RequestMethod.POST)
	public String saveSupplier(@ModelAttribute("supplier") Supplier supplier ) {
		service.save(supplier);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditSupplierForm(@PathVariable(name ="id")long id)  {
		ModelAndView mav= new ModelAndView("edit_supplier");
		Supplier supplier =service.get(id);
		mav.addObject("supplier",supplier);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteSupplier (@PathVariable(name ="id")long id)  {

		service.delete(id);
		return "redirect:/";
	}
}
