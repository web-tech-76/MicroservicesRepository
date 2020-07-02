package web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import web.app.services.LoginView;

@Controller
@RequestMapping("/users")
public class UsersController {

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("loginView", new LoginView());
		return "login/login";
	}

	@GetMapping("/layout")
	public String showLayout(Model model) {
		model.addAttribute("loginView", new LoginView());
		return "index";
	}

	@GetMapping("/new")
	public String register(Model model) {
		model.addAttribute("loginView", new LoginView());
		return "users/register";
	}

	@PostMapping("/insert")
	public String registerNew(@ModelAttribute LoginView loginView, Model model) {

		/*
		 * System.out.println("id" + loginView.getId()); System.out.println("first" +
		 * loginView.getFirstName()); System.out.println("last" +
		 * loginView.getLastName()); System.out.println("dob" + loginView.getDob());
		 */
		
		model.addAttribute("loginView", loginView);
		return "home/home";
	}

	@PutMapping("/update")
	public String userUpdate(@ModelAttribute LoginView loginView) {
		return "home/home";
	}

	@DeleteMapping("/delete/{id}")
	public String userDelete(@ModelAttribute LoginView loginView) {
		return "home/home";
	}

}
