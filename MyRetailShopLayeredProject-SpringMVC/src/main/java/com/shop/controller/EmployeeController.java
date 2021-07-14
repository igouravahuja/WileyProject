package com.shop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.bean.Items;
import com.shop.bean.Customer;
import com.shop.service.ShopService;

@Controller
public class EmployeeController {
	
	@Autowired
	private ShopService shopService;
	
//	@RequestMapping("/")
//	public ModelAndView openingPageController() {
//		return new ModelAndView("index");
//	}
	
	@RequestMapping("/")
	public String openingPageController() {
		return "index";
	}
	/*
	@RequestMapping("/inputForEmpSearch")
	public String getEmpIDForSearchPage() {
		return "inputEmpIdForSearch";
	}
	
	@RequestMapping("/searchEmp")
	public ModelAndView searchEmpController(@RequestParam("empId") String id) {
		Employee employee=null;
		try {
			employee=employeeService.findEmployee(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(employee!=null) {
			return new ModelAndView("displayEmployee", "employee", employee);
		}
		return new ModelAndView("output", "message", "Employee with id "+id+" doesnot exist");
	}
	*/
	

	@RequestMapping("/addItemsToCart")
	public ModelAndView insertEmpPageController() {
		return new ModelAndView("inputItemDetails", "item", new Items());
	}
	
	@RequestMapping("/insertItem")
	public ModelAndView insertEmployeeController(@RequestParam("itemId") int id,@RequestParam("quantity") int quantity )
	{
		try {
			double bill=shopService.addToCart(id,quantity);
				return new ModelAndView("output", "bill", bill);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return new ModelAndView("output", "message", "Saving Employee Failed!");
	
	}
	/*
	@RequestMapping("/deleteEmployeePage")
	public String deleteEmployeePageController() {
		return "inputEmpForDelete";
	}
	
	@RequestMapping("/deleteEmp")
	public ModelAndView deleteEmployeeController(@RequestParam("empId") String id) {
		try {
			if(employeeService.removeEmployee(Integer.parseInt(id))) {
				return new ModelAndView("output","message","Employee with ID "+id+" deleted Successfully!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("output","message","Employee with ID "+id+" deletion Failed!");
		
	}
	*/
	
	@RequestMapping("/displayItems")
	public ModelAndView getAllItemsController() {
		Collection<Items> items=null;
		try {
			items=shopService.getAllItems();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("displayAllItemsWithoutScriplets", "items", items);
	}
	
}
