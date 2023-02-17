package com.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	
	@GetMapping("/")
	public String homepage() {
		

		return "Welcome To Eshop";
	}

//	@RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
//	public ModelAndView editProduct(@PathVariable Long id) {
//		ModelAndView mav = new ModelAndView("EditProduct");
//		mav.addObject("product", productService.findById(id));
//		return mav;
//	}
//
//	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
//	public String deleteProduct(@PathVariable Long id) {
//		boolean result = productService.delete(id);
//		return "redirect:/";
//
//	}
//
//	@RequestMapping("/userslist")
//	public ModelAndView getUsers() {
//		ModelAndView mav = new ModelAndView("DisplayUsers");
//		mav.addObject("users", usersService.findAll());
//
//		return mav;
//	}
//
//	@RequestMapping(value = "/delete/user/{id}")
//	public String deleteUser(@PathVariable Long id) {
//		boolean result = usersService.delete(id);
//		return "redirect:/userslist";
//
//	}
//
//	@RequestMapping(value = "/edit/user/{id}")
//	public ModelAndView editUser(@PathVariable Long id, UsersData data) {
//		ModelAndView mav = new ModelAndView("EditUser");
//		mav.addObject("user", usersService.findById(id));
//		System.out.println("UserName : " + data.getUserName());
//		return mav;
//	}
//	
//	@RequestMapping("/orderlist")
//	public ModelAndView getOrders() {
//		ModelAndView mav = new ModelAndView("DisplayOrders");
//		mav.addObject("orders", ordersService.findAll());
//
//		return mav;
//	}


}
