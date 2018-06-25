package kr.cse.gt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.cse.gt.model.User;
import kr.cse.gt.service.UserService;

@Controller
public class MainCotroller {

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping("/home")
	public String test(Model model) {

		// User user = (User)
		// SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		// System.out.println(user.getUsername());
		//
		//
		// model.addAttribute("user", user);

		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, @RequestParam(value = "error", defaultValue = "false") Boolean error) {
		User user = new User();

		model.addAttribute("user", user);
		model.addAttribute("error", error);

		return "loginForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {
		User user = new User();

		user.setEmailAlert(true);

		model.addAttribute("user", user);

		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerVerity(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

		// System.out.println(user);
		if (bindingResult.hasErrors()) {
			System.out.println("error");
			return "registerForm";
		}

		User legacyUsername = userService.findByUsername(user.getUsername());
		User legacyUserEmail = userService.findByEmail(user.getEmail());

		System.out.println(user.getUsername());

		if (legacyUsername == null && legacyUserEmail == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setIsEnabled(false);
			userService.saveAndFlush(user);
			return "redirect:/login";
		}

		model.addAttribute("user", user);
		model.addAttribute("yet", "이미 아이디나 이메일이 존재합니다.");
		return "registerForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		return login(model, false);
	}

	@RequestMapping(value = "/alertChanged", method = RequestMethod.POST)
	public String alertManage(@ModelAttribute("user") User user) {

		System.out.println("alert chkec =" + user.getEmailAlert());

		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		currentUser.setEmailAlert(user.getEmailAlert());
		currentUser.setAndroidAlert(user.getAndroidAlert());

		userService.saveAndFlush(currentUser);

		return "redirect:/home";
	}

	@RequestMapping(value = "/manager", method = RequestMethod.POST)
	public String managerUserEnabled(Model model) {

		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (currentUser.getUsername().equals("gim224")) {

			List<User> users = userService.findAll();
			users.remove(currentUser);
			model.addAttribute("users", users);

			return "managerForm";
		}

		return "redirect:/home";
	}

}