package com.sts.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import com.mysql.cj.protocol.Message;
import com.sts.helper.Messages;
import com.sts.model.User;
import com.sts.userrepo.UserRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
//@RestController //mostly used for creating rest apis/'
public class TestController {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/test")
	public String test() {
		return "Connected SuccessFully";
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Home - Quiker");
		return "home";
	}

	@RequestMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "About - Quiker");
		return "about";
	}

	@RequestMapping("/userhome")
	public String userhome(@RequestParam("username") String username, Model model) {
		User user = new User();
		user.setName(username);
		model.addAttribute("user", user);
		return "userhome";
	}

	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("title", "Sign Up - Quiker");
		return "signup";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		model.addAttribute("title", "Login - Quiker");
		return "/login";
	}

	User user = new User();
	@Autowired
	UserRepository urepo;

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)

	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult res,
			@RequestParam(value = "pass", defaultValue = "p") String pass,
			@RequestParam(value = "gender", defaultValue = "male") String gender,
			@RequestParam(value = "agrement", defaultValue = "false") boolean agrement, Model model,
			Principal principal, HttpSession session) {
		try {
			if (!agrement) {
				String message = "Agreement not accepted !";
				throw new Exception("Agreement not accepted !");
			}
			if (res.hasErrors()) {
				System.out.println("Error : " + res.toString());
				model.addAttribute("user", user);
				return "signup";
			}

			user.setPassword(passwordEncoder.encode(user.getPassword()));

			this.urepo.save(user);
			model.addAttribute("user", new User());
			session.setAttribute("message", new Messages("Successfully Registered", "alert-success"));
			return "login";

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("user", user);
			session.setAttribute("message", new Messages("404 Something Went Wrong" + e.getMessage(), "alert-danger"));
			return "signup";
		}

	}

//	@RequestMapping(value = "/getusers" , method = RequestMethod.GET)
////	@GetMapping = @RequestMapping(value = "/getusers" , method = RequestMethod.GET)
//	public User getUsers() {
//		User user = new User();
//		user.setName("Kamran Ali");
//		user.setEmail("kamuraza@gmail.com");
//		user.setPassword("123");
//		user.setPhonenumber("123");
//		user.setUsername("ali");
//		return user;
//	}
}
