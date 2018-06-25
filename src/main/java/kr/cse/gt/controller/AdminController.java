package kr.cse.gt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.cse.gt.model.User;
import kr.cse.gt.service.UserService;

@Controller
@RequestMapping("/admin/user")
public class AdminController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/del/{id}")
	public String deleteUser(@PathVariable int id) {

		User user = userService.findByOne(id);

		userService.deleteUser(user);

		return "redirect:/home";
	}

	@RequestMapping(value = "/update/{id}/enabled")
	public String updateUserEnabled(@PathVariable int id) {

		User user = userService.findByOne(id);

		user.setIsEnabled(true);
		userService.saveAndFlush(user);

		return "redirect:/home";
	}
}
