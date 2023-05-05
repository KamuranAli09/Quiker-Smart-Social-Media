package com.sts.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sts.helper.Messages;
import com.sts.model.User;
import com.sts.userrepo.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Model model, Principal principal) {
		model.addAttribute("title", "Home - Quiker");
		String userName = principal.getName();
		System.out.println(userName);
		User user = userRepo.getUserByUserName(userName);
		System.out.println(user);
		model.addAttribute("user", user);
		return "NormalUser/userprofile";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute User user, @RequestParam("dp") MultipartFile file, Model model,
			Principal principal, HttpSession session) {
		try {
		if(!file.isEmpty()) {
			
		}
		String name = principal.getName();
		User u = this.userRepo.getUserByUserName(name);
//		Processing and uploading file
		if(file.isEmpty()) {
//			If file is empty
			System.out.println("Error");
			
		}
		else {
			user.setImg(file.getOriginalFilename());
			File saveFile = new ClassPathResource("/static/ProfilePhotos").getFile();
			Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename());
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			System.out.print("image is uploaded");
		}
		this.userRepo.save(user);
		return "NormalUser/userprofile";
	} catch (Exception e) {
		e.printStackTrace();
		model.addAttribute("user", user);
		session.setAttribute("message", new Messages("404 Something Went Wrong" + e.getMessage(), "alert-danger"));
		return "NormalUser/userprofile";
	}

	}

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat(Model model, Principal principal) {
		model.addAttribute("title", "Home - Quiker");
		String userName = principal.getName();
		System.out.println(userName);
		User user = userRepo.getUserByUserName(userName);
		System.out.println(user);
		model.addAttribute("user", user);
		return "NormalUser/chat";
	}
}
